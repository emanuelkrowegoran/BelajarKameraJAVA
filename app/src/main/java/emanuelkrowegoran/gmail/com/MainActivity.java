package emanuelkrowegoran.gmail.com;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button cmr;
    ImageView imageView;
    Bitmap imageBitmap;
//mendeklarasikan varible variable yang akan digunakan pada program ini

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//menghubungkan kelas java dengan kelas xml
        cmr = findViewById(R.id.cmr);
        imageView = findViewById(R.id.imageView);
//mencari id camera  dan id imageview pada kelas xml
        cmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, 0);
//fungsi pemanggilan varible cmr sehingga terjadi intent untuk membuka kemera
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//Mendeklarasikan Nilai Parameter ke super Class
        if (resultCode == RESULT_OK) {
            imageBitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(imageBitmap);
//mendeklarasikan jika berhasil mengambil gambar dan user klik ok maka akna ditampilkan pada imageview
            SimpanGambar(imageBitmap);
//mendeklarasikan fungsi untuk menyimpan gambar di device hp
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
//melakukan if else jika user mengklik cancleed maka akan  kembali ke awal layout
        }
    }
    private void SimpanGambar(Bitmap finalBitmap) {
        File mediaStorageDir= new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString());
//mendeklarasikan fungsi untuk menyimpan gambar ke stroge hp
        if (!mediaStorageDir.exists()) {
            mediaStorageDir.mkdirs();
//menyompan data hasil foto ke dalam direktory stroge hp
        }

        Toast.makeText(this, mediaStorageDir.toString(), Toast.LENGTH_LONG).show();
//membuat toast untuk menampilkan keterangan tempat data disimpan

        Random generator = new Random();
        int namafile = 1;
        namafile = generator.nextInt(namafile);
        File filename = new File (mediaStorageDir,  "IMG_"+ namafile +".jpg");
        if (filename.exists ())
            filename.delete ();
//membuat nama file hasil gambar yang akan disimpan pada stroge hp
        }
    }




