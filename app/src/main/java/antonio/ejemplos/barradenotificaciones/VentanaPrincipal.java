package antonio.ejemplos.barradenotificaciones;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class VentanaPrincipal extends ActionBarActivity {

    NotificationManager nm;//Referencia al servicio de Notificaciones de Android....
    private static final int ID_NOTIFICACION_PERSONAL = 1;//Constante que va a ser utilizada después...
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventana_principal);

        Button btn_notificar = (Button) findViewById(R.id.btn_notificacion);


        nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        //NotificationCompat.Builder notificacion = new NotificationCompat.Builder(MainActivity.this);

        //En el click del botón....


        btn_notificar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Notification notificacion = new Notification(R.drawable.img1, "Notoficación personal", System.currentTimeMillis());

                PendingIntent intencionPendiente = PendingIntent.getActivity(getApplicationContext(), 0, new Intent(getApplicationContext(), SegundaVentana.class), 0);
                notificacion.setLatestEventInfo(getApplicationContext(), "NOTIFICACIÓN", "Notificación pendiente", intencionPendiente);
                nm.notify(ID_NOTIFICACION_PERSONAL, notificacion);


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ventana_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {//All cerrar la app obligamos a que se cierre también la notificación
        super.onDestroy();
        nm.cancel(ID_NOTIFICACION_PERSONAL);


    }
}
