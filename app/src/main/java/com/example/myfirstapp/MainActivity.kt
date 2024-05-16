package com.example.myfirstapp

import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.myfirstapp.databinding.ActivityMainBinding
import java.net.URL


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var textView: TextView
    private lateinit var imgView: ImageView
    // Some transient state for the activity instance.

    val direct=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
    val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
        val galleryUri = it
        try {
            binding.imageSelectIv.setImageURI(galleryUri)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {


        // Call the superclass onCreate to complete the creation of
        // the activity, like the view hierarchy.
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        imgView = findViewById(R.id.imageSelect_iv)

        imgView.setOnClickListener {
            galleryLauncher.launch("image/*")
        }

    }
}

// private fun requestPermission(){
// if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
// when{
// ContextCompat.checkSelfPermission(
// this,
// Manifest.permission.READ_EXTERNAL_STORAGE
// ) == PackageManager.PERMISSION_GRANTED ->{
// pickPhotoFromGallery()
// }
// }
// }
// else{
// pickPhotoFromGallery()
//
// }
//
//
// private fun pickPhotoFromGallery()
// {
// val intent=Intent(Intent.ACTION_GET_CONTENT)
// intent.type="image/*"
// val data=result.data?.data
//
// }
// override fun onCreateOptionsMenu(menu: Menu): Boolean {
// // Inflate the menu; this adds items to the action bar if it is present.
// menuInflater.inflate(R.menu.menu_main, menu)
// return true
// }
//
// override fun onOptionsItemSelected(item: MenuItem): Boolean {
// // Handle action bar item clicks here. The action bar will
// // automatically handle clicks on the Home/Up button, so long
// // as you specify a parent activity in AndroidManifest.xml.
// return when (item.itemId) {
// R.id.action_settings -> true
// else -> super.onOptionsItemSelected(item)
// }
// }
//
// override fun onSupportNavigateUp(): Boolean {
// val navController = findNavController(R.id.nav_host_fragment_content_main)
// return navController.navigateUp(appBarConfiguration)
// || super.onSupportNavigateUp()
// }*/