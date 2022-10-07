package app.test.myregstration

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginPage : AppCompatActivity() {


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.loginpage)

        val register = findViewById<TextView>(R.id.btnin)
        val login = findViewById<Button>(R.id.btnup)
        val ediEmail = findViewById<EditText>(R.id.edtemail)
        val ediPassword = findViewById<EditText>(R.id.edtpass)

        val sharedPreFences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)
        val txtPass = sharedPreFences.getString("password","")
        val txtEmail = sharedPreFences.getString("email","")

        login.setOnClickListener {
            if (ediEmail.text.isNotEmpty() && ediPassword.text.isNotEmpty()){
                if (txtEmail == ediEmail.text.toString() && txtPass == ediPassword.text.toString()){
                    startActivity(Intent(this, PasswordPage::class.java))
                    finish()

                    val sharedPreFence = getSharedPreferences("MyReg", MODE_PRIVATE)
                    val txtPas = sharedPreFence.getString("password","")

                    if (txtPas == ""){
                        val intent = Intent(this, PasswordPage::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        val intent = Intent(this, EmptySecret::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }else{
                ediEmail.error = ""
                ediPassword.error = ""
            }
        }
        register.setOnClickListener{
            val intent = Intent(this,Registerpage::class.java)
            startActivity(intent)
            finish()
        }
    }
}