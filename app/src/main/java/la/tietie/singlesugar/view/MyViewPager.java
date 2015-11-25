package la.tietie.singlesugar.view;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager {
	private final String TAG = "MyViewPager";
	PointF downP = new PointF();
	PointF curP = new PointF();
	OnSingleTouchListener onSingleTouchListener;

	// private boolean clickFlag = true;

	public MyViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyViewPager(Context context) {
		super(context);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		curP.x = arg0.getX();
		curP.y = arg0.getY();

		if (arg0.getAction() == MotionEvent.ACTION_DOWN) {
			downP.x = arg0.getX();
			downP.y = arg0.getY();
			getParent().requestDisallowInterceptTouchEvent(true);
		}

		if (arg0.getAction() == MotionEvent.ACTION_MOVE) {
			getParent().requestDisallowInterceptTouchEvent(true);
		}

		if (arg0.getAction() == MotionEvent.ACTION_UP) {
			if (downP.x == curP.x && downP.y == curP.y) {
				onSingleTouch();
				// clickFlag = onInterceptTouchEvent(arg0);
				// clickFlag = true;
				// Log.i(TAG, "clickFlag==" + clickFlag);
				// clickFlag = true;
				return false;
			}
		}

		// return super.onTouchEvent(arg0);
		return super.onTouchEvent(arg0);
	}

	
	public void onSingleTouch() {
		if (onSingleTouchListener != null) {
			onSingleTouchListener.onSingleTouch();
		}
	}

	public interface OnSingleTouchListener {
		public void onSingleTouch();
	}

	public void setOnSingleTouchListener(
			OnSingleTouchListener onSingleTouchListener) {
		this.onSingleTouchListener = onSingleTouchListener;
	}

}