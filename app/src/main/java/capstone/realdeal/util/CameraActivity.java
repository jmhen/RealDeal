package capstone.realdeal.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import capstone.realdeal.R;

public class CameraActivity extends Activity {
    private Camera mCamera;//相机
    private SurfacePreView mPreView;//视图
    private FrameLayout mFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_view);
        mFrameLayout = (FrameLayout) findViewById(R.id.framelayout);
        if (checkCameraHardware(this)) {
            mCamera = getCamera();
            mPreView = new SurfacePreView(this, mCamera);
            mFrameLayout.addView(mPreView);
        }
    }
    /**
     * 拍照对焦
     * @param view
     */
    public void takephoto(View view){
        mCamera.autoFocus(new Camera.AutoFocusCallback() {
            @Override
            public void onAutoFocus(boolean success, Camera camera) {
                mCamera.takePicture(null, null, mPicture);
            }
        });
    }
    /**
     * 拍照后的图片保存
     */
    private Camera.PictureCallback mPicture = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            try {
                File file = new File("/sdcard/file/aa.jpg");
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(data);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
    /**
     * 判断照相机是否存在
     * @param context
     * @return
     */
    private boolean checkCameraHardware(Context context){
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            return true;
        }
        return false;
    }
    /**
     * 初始化照相机
     * @return
     */
    public static Camera getCamera(){
        Camera camera = null;
        try {
            camera = Camera.open(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return camera;
    }
    /**
     * 实现拍照视图
     */
    @SuppressWarnings("deprecation")
    private class SurfacePreView extends SurfaceView implements SurfaceHolder.Callback{
        private Camera mCamera;
        private SurfaceHolder mHolder;
        public SurfacePreView(Context context, Camera camera) {
            super(context);
            mCamera = camera;
            mHolder = getHolder();
            mHolder.addCallback(this);
            mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            try {
                mCamera.setPreviewDisplay(mHolder);
                mCamera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            if (holder.getSurface() == null) {
                return;
            }
            try {
                mCamera.stopPreview();
                mCamera.setPreviewDisplay(mHolder);
                mCamera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            //
            mCamera = null;
        }
    }
}