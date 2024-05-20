package com.example.mapkot
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.mapkot.databinding.ActivityQuiz2Binding


class QuizActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityQuiz2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuiz2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Получение данных из Intent
        val question = intent.getStringExtra("question")
        val answerA = intent.getStringExtra("answerA")
        val answerB = intent.getStringExtra("answerB")
        val answerC = intent.getStringExtra("answerC")
        val answerD = intent.getStringExtra("answerD")
        val correctAnswerId = intent.getIntExtra("correctAnswer", 0)
        val correctAnswer = getString(correctAnswerId)
        val latitude = intent.getDoubleExtra("latitude", 0.0)
        val longtitude = intent.getDoubleExtra("longtitude", 0.0)
        val imageResource = intent.getIntExtra("imageResource", 0)
        val urlCorr = intent.getStringExtra("correctUrl")
        Log.d("longtitude", "Корректная ссылка: $longtitude")
         // Используем "correctAnswer" как ключ

        // Установка текста вопроса и ответов
        binding.text.text = question
        binding.btnA.text = answerA
        binding.btnB.text = answerB
        binding.btnC.text = answerC
        binding.btnD.text = answerD

        // Установка изображения, если оно задано
        if (imageResource != 0) {
            binding.imageView.setImageResource(imageResource)
        }

        // Листенер для кнопок
        val btnListener = View.OnClickListener { view ->
            val selectedAnswer = when (view.id) {
                R.id.btnA -> binding.btnA.text.toString()
                R.id.btnB -> binding.btnB.text.toString()
                R.id.btnC -> binding.btnC.text.toString()
                R.id.btnD -> binding.btnD.text.toString()
                else -> ""
            }

            if (selectedAnswer == correctAnswer) {
                Toast.makeText(
                    this@QuizActivity2,
                    "Правильный ответ!",
                    Toast.LENGTH_SHORT
                ).show()
                AlertDialog.Builder(this)
                    .setTitle("Правильный ответ!")
                    .setMessage("Вы выбрали правильный ответ.")
                    .setPositiveButton("Дальше") { dialog, _ ->
                        dialog.dismiss()
                        // Логика перехода к следующему вопросу или другое действие

                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("url", urlCorr)
                        intent.putExtra("isCorrectAnswer", true)
                        intent.putExtra("latitude",latitude)
                        intent.putExtra("longtitude",longtitude)
                        startActivity(intent)
                    }
                    .show()
                intent

            } else {
                AlertDialog.Builder(this)
                    .setTitle("Неправильный ответ!")
                    .setMessage("Вы выбрали неправильный ответ.")
                    .setPositiveButton("Попробовать снова") { dialog, _ ->
                        dialog.dismiss()
                        // Логика перехода к следующему вопросу или другое действие
                    }
                    .setNegativeButton("Узнать больше") { dialog, _ ->
                        if (urlCorr != null) {
                            val intent = Intent(this, WebViewActivity::class.java)
                            intent.putExtra("url", urlCorr)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "URL не найден", Toast.LENGTH_SHORT).show()
                        }
                    }
                    .show()
            }
            }

        binding.btnA.setOnClickListener(btnListener)
        binding.btnB.setOnClickListener(btnListener)
        binding.btnC.setOnClickListener(btnListener)
        binding.btnD.setOnClickListener(btnListener)
    }
}