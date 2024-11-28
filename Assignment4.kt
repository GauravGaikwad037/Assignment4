 
● activity_main.xml 
 
<?xml version="1.0" encoding="utf-8"?> 
<RelativeLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"     android:layout_width="match_parent"     android:layout_height="match_parent"     android:background="@color/background_color"     android:padding="16dp"> 
    <!-- TextView -->     <TextView         android:id="@+id/myTextView"         android:layout_width="wrap_content"         android:layout_height="wrap_content"         android:text="@string/sample_text"         android:textSize="20sp"         android:textColor="@color/black"         android:layout_centerHorizontal="true"         android:layout_marginTop="50dp"         android:gravity="center"         android:padding="10dp" /> 
    <!-- Button 1 -->     <Button         android:id="@+id/button1"         android:layout_width="wrap_content"         android:layout_height="wrap_content"         android:layout_below="@id/myTextView"         android:layout_marginTop="40dp"         android:text="@string/button1_text"         android:backgroundTint="@color/button_color"         android:textColor="@color/black"         android:layout_centerHorizontal="true" /> 
    <!-- Button 2 -->     <Button         android:id="@+id/button2"         android:layout_width="wrap_content"         android:layout_height="wrap_content"         android:layout_below="@id/button1"         android:layout_marginTop="20dp"         android:text="@string/button2_text"         android:backgroundTint="@color/button_color"         android:textColor="@color/black"         android:layout_centerHorizontal="true" /> 
    <!-- Button 3 -->     <Button 
        android:id="@+id/button3"         android:layout_width="wrap_content"         android:layout_height="wrap_content"         android:layout_below="@id/button2"         android:layout_marginTop="20dp"         android:text="@string/button3_text"         android:backgroundTint="@color/button_color"         android:textColor="@color/black"         android:layout_centerHorizontal="true" /> 
</RelativeLayout> 
 
● MainActivity.kt 
 
package com.example.assignment_4 
 
import android.os.Bundle import android.widget.Button import android.widget.RelativeLayout import android.widget.TextView import androidx.activity.ComponentActivity import androidx.activity.compose.setContent import androidx.activity.enableEdgeToEdge import androidx.compose.foundation.layout.fillMaxSize import androidx.compose.foundation.layout.padding import androidx.compose.material3.Scaffold import androidx.compose.material3.Text import androidx.compose.runtime.Composable import androidx.compose.ui.Modifier import androidx.compose.ui.tooling.preview.Preview 
import com.example.assignment_4.ui.theme.Assignment_4Theme 
 
class MainActivity : ComponentActivity() {     private var counter = 0 // Counter for Button 1 clicks     override fun onCreate(savedInstanceState: Bundle?) {         super.onCreate(savedInstanceState)         setContentView(R.layout.activity_main)         val textView = findViewById<TextView>(R.id.myTextView)         val button1 = findViewById<Button>(R.id.button1)         val button2 = findViewById<Button>(R.id.button2)         val button3 = findViewById<Button>(R.id.button3)         // Button 1: Increment a counter and update the TextView         button1.setOnClickListener { 
            counter++             textView.text = "Button clicked $counter times" 
        } 
        // Button 2: Change the height of the TextView         button2.setOnClickListener {             textView.layoutParams.height = 200 
            textView.requestLayout() 
        } 
        // Button 3: Center the text on the screen         button3.setOnClickListener {             val layoutParams = textView.layoutParams as 
                    RelativeLayout.LayoutParams             layoutParams.addRule( 
                RelativeLayout.CENTER_IN_PARENT, 
                RelativeLayout.TRUE 
            ) 
            textView.layoutParams = layoutParams 
        } 
    } 
} 
@Composable 
fun Greeting(name: String, modifier: Modifier = Modifier) {     Text(         text = "Hello $name!", 
        modifier = modifier 
    ) 
} 
 
@Preview(showBackground = true) 
@Composable 
fun GreetingPreview() {     Assignment_4Theme { 
        Greeting("Android") 
    } 
} 
