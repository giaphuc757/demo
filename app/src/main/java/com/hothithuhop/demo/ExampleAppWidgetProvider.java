package com.hothithuhop.demo;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class ExampleAppWidgetProvider extends AppWidgetProvider {

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;

        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];

            //sử dụng quyền bên thứ 3
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);


            //thiết lập layout cho widget và button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.example_appwidget);
            views.setOnClickPendingIntent(R.id.btn, pendingIntent);

            //yêu cầu AppWidgetManager thực hiện cập nhật trên widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}