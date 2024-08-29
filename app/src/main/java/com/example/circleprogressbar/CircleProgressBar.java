package com.example.circleprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CircleProgressBar extends View {

	private Paint backgroundPaint;
	private Paint progressPaint;
	private int strokeWidth = 20;
	private int progress = 0;
	private int max = 100;

	public CircleProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	private void init(Context context, AttributeSet attrs) {
		// Initialize paints
		backgroundPaint = new Paint();
		backgroundPaint.setColor(0xFFE0E0E0); // default gray
		backgroundPaint.setStyle(Paint.Style.STROKE);
		backgroundPaint.setStrokeWidth(strokeWidth);
		backgroundPaint.setAntiAlias(true);

		progressPaint = new Paint();
		progressPaint.setColor(0xFFFF4081); // default pink
		progressPaint.setStyle(Paint.Style.STROKE);
		progressPaint.setStrokeWidth(strokeWidth);
		progressPaint.setAntiAlias(true);

		// Load custom attributes
		TypedArray a = context.getTheme().obtainStyledAttributes(
				attrs,
				R.styleable.CircleProgressBar,
				0, 0);

		try {
			strokeWidth = a.getDimensionPixelSize(R.styleable.CircleProgressBar_strokeWidth, strokeWidth);
			progress = a.getInt(R.styleable.CircleProgressBar_progress, progress);
			max = a.getInt(R.styleable.CircleProgressBar_max, max);

			progressPaint.setColor(a.getColor(R.styleable.CircleProgressBar_progressColor, progressPaint.getColor()));
			backgroundPaint.setColor(a.getColor(R.styleable.CircleProgressBar_backgroundColor, backgroundPaint.getColor()));
		} finally {
			a.recycle();
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		int width = getWidth();
		int height = getHeight();
		int radius = Math.min(width, height) / 2 - strokeWidth / 2;

		// Draw the background circle
		canvas.drawCircle(width / 2, height / 2, radius, backgroundPaint);

		// Draw the progress
		float angle = 360 * progress / max;
		canvas.drawArc(
				strokeWidth / 2, strokeWidth / 2,
				width - strokeWidth / 2, height - strokeWidth / 2,
				-90, angle, false, progressPaint);
	}

	// Methods to set and get progress
	public void setProgress(int progress) {
		this.progress = progress;
		invalidate();
	}

	public int getProgress() {
		return progress;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMax() {
		return max;
	}
}

