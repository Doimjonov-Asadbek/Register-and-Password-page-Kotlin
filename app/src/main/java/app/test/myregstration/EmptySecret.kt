package app.test.myregstration

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EmptySecret : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty_secret)

        val textView = findViewById<TextView>(R.id.textView)

        textView.setOnClickListener {
            startActivity(Intent(this,LoginPage::class.java))
            finish()
        }

    }

}