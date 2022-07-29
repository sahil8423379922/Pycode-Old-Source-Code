package com.priyanka.pycode;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
//import android.priyanka.pycode.R;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.net.URI;

import static android.os.Environment.DIRECTORY_DOCUMENTS;
import static android.os.Environment.DIRECTORY_DOWNLOADS;
import static android.os.Environment.DIRECTORY_MOVIES;
import static android.os.Environment.DIRECTORY_MUSIC;
import static java.lang.System.load;

public class Fundamental_download extends AppCompatActivity {
    private Button download_btn;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;
    private StorageReference ref;
    private Button filemanager;
    private TextView show;
    private long downloadID;
    private ProgressBar mProgressBar;
  File path,file_check;
  String Filename,get,f;
  TextView pathshow;
  WebView file;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundamental_download);

        file = findViewById(R.id.filecvsdv);
        file.loadUrl("https://firebasestorage.googleapis.com/v0/b/pycode-ebbac.appspot.com/o/file.pdf?alt=media&token=4669b5c4-2e36-4984-9c4d-b954d1aa37d1");

        /*download_btn = findViewById(R.id.download);
        show = findViewById(R.id.status);
        mProgressBar = findViewById(R.id.progressbar1);
        pathshow = findViewById(R.id.value);

        File applictionFile =  new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS)+ "/"+"file.pdf");

        if(applictionFile != null && applictionFile.exists()){

            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();

        }

;

        filemanager = findViewById(R.id.filemanager);
        filemanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()
                        + "/Documents/");
                intent.setDataAndType(uri, "text/csv");
                startActivity(Intent.createChooser(intent, "Open folder"));
            }
        });

        registerReceiver(onDownloadComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        mProgressBar.setVisibility(View.GONE);
        download_btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {

                pathshow.setText(get);
                checkFile();
                //mProgressBar.setVisibility(View.VISIBLE);
                //show.setVisibility(View.VISIBLE);

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void checkFile() {
        String path = this.getFilesDir().getAbsolutePath() + "file.pdf";
   File file = new File(path);
   if(file.isFile())
   {
       Toast.makeText(this, "File already exist", Toast.LENGTH_SHORT).show();
   }
   else
   {
       download();
   }

    }

    private void download() {

        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();

        ref = storageReference.child("file.pdf");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadfile(Fundamental_download.this, "file", ".pdf", DIRECTORY_DOWNLOADS, url);


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }


    public void downloadfile(Context context, String filename, String fileextension, String destinationfolder, String url) {


        final DownloadManager downloadManager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationfolder, filename + fileextension);
        downloadID = downloadManager.enqueue(request);
        final long downloadId = downloadID;
        new Thread(new Runnable() {

            @Override
            public void run() {
                boolean downloading = true;

                while (downloading) {

                    DownloadManager.Query q = new DownloadManager.Query();
                    q.setFilterById(downloadId);
                    Cursor cursor = downloadManager.query(q);
                    //statusMessage(cursor);
                    cursor.moveToFirst();
                    int bytes_downloaded = cursor.getInt(cursor
                            .getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
                    int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

                    if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                        downloading = false;
                    }
                    final int dl_progress = (int) ((bytes_downloaded * 100l) / bytes_total);

                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {

                            mProgressBar.setProgress(dl_progress);

                        }
                    });


                }
            }
        }).start();


    }

    private BroadcastReceiver onDownloadComplete = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //Fetching the download id received with the broadcast
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            //Checking if the received broadcast is for our enqueued download by matching download id
            if (downloadID == id) {
                show.setText("Download Complete");
                Toast.makeText(Fundamental_download.this, "Download Completed", Toast.LENGTH_SHORT).show();
                mProgressBar.setVisibility(View.GONE);
                filemanager.setVisibility(View.VISIBLE);


            }

        }
    };

   public void openpdf()
    {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath() + File.separator +
                "file.pdf");
        Uri path = Uri.fromFile(file);

        Intent pdfOpenintent = new Intent(Intent.ACTION_VIEW);
        pdfOpenintent.setDataAndType(path, "application/pdf");
        try {
            this.startActivity(pdfOpenintent);
        } catch (ActivityNotFoundException e) {

        }*/
    }






}
