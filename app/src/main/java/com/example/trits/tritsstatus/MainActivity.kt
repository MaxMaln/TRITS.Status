package com.example.trits.tritsstatus

import android.content.ContentValues
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trits.tritsstatus.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var dbHelper: DBHelper? = null

    fun Update()
    {
        val database = dbHelper!!.writableDatabase
        val status_array = ArrayList<Status>()
        val cursor = database.query(DBHelper.TABLE_Service, null, null, null, null, null, null)
        if (cursor.moveToFirst()) {
            val nameIndex = cursor.getColumnIndex(DBHelper.NAME)
            val statusIndex = cursor.getColumnIndex(DBHelper.Status)
            do {
                status_array.add(Status(cursor.getString(nameIndex), cursor.getString(statusIndex)))
            } while (cursor.moveToNext())
        }
        cursor.close()
        val adapter = StatusAdapter(this, R.layout.list_item, status_array)
        binding.StatusList.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //добавление в базу данных изначальных сервисов
        dbHelper = DBHelper(this)

        val database = dbHelper!!.writableDatabase

        val contentValues = ContentValues()

        var onestart = 0
        val curso = database.query(DBHelper.TABLE_Service, null, null, null, null, null, null)
        try {
            if (curso.moveToFirst()) {
                do {
                        onestart+=1
                } while (curso.moveToNext())
            }
            curso.close()
        }
        finally { }
        if(onestart == 0)
        {
            contentValues.put(DBHelper.NAME, "Веб-сайт")
            contentValues.put(DBHelper.Status, "Работает")
            database.insert(DBHelper.TABLE_Service, null, contentValues)
            contentValues.put(DBHelper.NAME, "Одноклассники")
            contentValues.put(DBHelper.Status, "Работает")
            database.insert(DBHelper.TABLE_Service, null, contentValues)
            contentValues.put(DBHelper.NAME, "Мобильное приложение")
            contentValues.put(DBHelper.Status, "Работает")
            database.insert(DBHelper.TABLE_Service, null, contentValues)
            contentValues.put(DBHelper.NAME, "Страница ВК")
            contentValues.put(DBHelper.Status, "Работает")
            database.insert(DBHelper.TABLE_Service, null, contentValues)
            contentValues.put(DBHelper.NAME, "Телеграмм")
            contentValues.put(DBHelper.Status, "Работает")
            database.insert(DBHelper.TABLE_Service, null, contentValues)
        }

        //добавление в список
        Update()

        binding.ChangeButton1.setOnClickListener {
            Update()
            if(binding.checkBox1.isChecked)
            {
                val numbers: Array<String> = arrayOf("Веб-сайт")
                val content = ContentValues()
                content.put(DBHelper.Status,"Работает")
                database.update(DBHelper.TABLE_Service, content, "service_name = ?",numbers)
            }
            else if(binding.checkBox2.isChecked)
            {
                val numbers: Array<String> = arrayOf("Веб-сайт")
                val content = ContentValues()
                content.put(DBHelper.Status,"Нестабильно")
                database.update(DBHelper.TABLE_Service, content, "service_name = ?",numbers)
            }
            else if(binding.checkBox3.isChecked)
            {
                val numbers: Array<String> = arrayOf("Веб-сайт")
                val content = ContentValues()
                content.put(DBHelper.Status,"Не работает")
                database.update(DBHelper.TABLE_Service, content, "service_name = ?",numbers)
            }
        }
        binding.ChangeButton2.setOnClickListener {
            Update()
            if(binding.checkBox1.isChecked)
            {
                val numbers: Array<String> = arrayOf("Одноклассники")
                val content = ContentValues()
                content.put(DBHelper.Status,"Работает")
                database.update(DBHelper.TABLE_Service, content, "service_name = ?",numbers)
            }
            else if(binding.checkBox2.isChecked)
            {
                val numbers: Array<String> = arrayOf("Одноклассники")
                val content = ContentValues()
                content.put(DBHelper.Status,"Нестабильно")
                database.update(DBHelper.TABLE_Service, content, "service_name = ?",numbers)
            }
            else if(binding.checkBox3.isChecked)
            {
                val numbers: Array<String> = arrayOf("Одноклассники")
                val content = ContentValues()
                content.put(DBHelper.Status,"Не работает")
                database.update(DBHelper.TABLE_Service, content, "service_name = ?",numbers)
            }
        }
        binding.ChangeButton3.setOnClickListener {
            Update()
            if(binding.checkBox1.isChecked)
            {
                val numbers: Array<String> = arrayOf("Мобильное приложение")
                val content = ContentValues()
                content.put(DBHelper.Status,"Работает")
                database.update(DBHelper.TABLE_Service, content, "service_name = ?",numbers)
            }
            else if(binding.checkBox2.isChecked)
            {
                val numbers: Array<String> = arrayOf("Мобильное приложение")
                val content = ContentValues()
                content.put(DBHelper.Status,"Нестабильно")
                database.update(DBHelper.TABLE_Service, content, "service_name = ?",numbers)
            }
            else if(binding.checkBox3.isChecked)
            {
                val numbers: Array<String> = arrayOf("Мобильное приложение")
                val content = ContentValues()
                content.put(DBHelper.Status,"Не работает")
                database.update(DBHelper.TABLE_Service, content, "service_name = ?",numbers)
            }
        }
        binding.ChangeButton4.setOnClickListener {
            Update()
            if(binding.checkBox1.isChecked)
            {
                val numbers: Array<String> = arrayOf("Страница ВК")
                val content = ContentValues()
                content.put(DBHelper.Status,"Работает")
                database.update(DBHelper.TABLE_Service, content, "service_name = ?",numbers)
            }
            else if(binding.checkBox2.isChecked)
            {
                val numbers: Array<String> = arrayOf("Страница ВК")
                val content = ContentValues()
                content.put(DBHelper.Status,"Нестабильно")
                database.update(DBHelper.TABLE_Service, content, "service_name = ?",numbers)
            }
            else if(binding.checkBox3.isChecked)
            {
                val numbers: Array<String> = arrayOf("Страница ВК")
                val content = ContentValues()
                content.put(DBHelper.Status,"Не работает")
                database.update(DBHelper.TABLE_Service, content, "service_name = ?",numbers)
            }
        }
        binding.ChangeButton5.setOnClickListener {
            Update()
            if(binding.checkBox1.isChecked)
            {
                val numbers: Array<String> = arrayOf("Телеграмм")
                val content = ContentValues()
                content.put(DBHelper.Status,"Работает")
                database.update(DBHelper.TABLE_Service, content, "service_name = ?",numbers)
            }
            else if(binding.checkBox2.isChecked)
            {
                val numbers: Array<String> = arrayOf("Телеграмм")
                val content = ContentValues()
                content.put(DBHelper.Status,"Нестабильно")
                database.update(DBHelper.TABLE_Service, content, "service_name = ?",numbers)
            }
            else if(binding.checkBox3.isChecked)
            {
                val numbers: Array<String> = arrayOf("Телеграмм")
                val content = ContentValues()
                content.put(DBHelper.Status,"Не работает")
                database.update(DBHelper.TABLE_Service, content, "service_name = ?",numbers)
            }
        }

        //Блокировка и разблокировка чекбоксов
        binding.checkBox1.setOnClickListener{

            binding.ChangeButton1.isEnabled = binding.checkBox1.isChecked || binding.checkBox2.isChecked || binding.checkBox3.isChecked
            binding.ChangeButton2.isEnabled = binding.checkBox1.isChecked || binding.checkBox2.isChecked || binding.checkBox3.isChecked
            binding.ChangeButton3.isEnabled = binding.checkBox1.isChecked || binding.checkBox2.isChecked || binding.checkBox3.isChecked
            binding.ChangeButton4.isEnabled = binding.checkBox1.isChecked || binding.checkBox2.isChecked || binding.checkBox3.isChecked
            binding.ChangeButton5.isEnabled = binding.checkBox1.isChecked || binding.checkBox2.isChecked || binding.checkBox3.isChecked

            if(binding.checkBox1.isChecked)
            {
                binding.checkBox2.isChecked = false
                binding.checkBox3.isChecked = false
            }
        }
        binding.checkBox2.setOnClickListener{

            binding.ChangeButton1.isEnabled = binding.checkBox1.isChecked || binding.checkBox2.isChecked || binding.checkBox3.isChecked
            binding.ChangeButton2.isEnabled = binding.checkBox1.isChecked || binding.checkBox2.isChecked || binding.checkBox3.isChecked
            binding.ChangeButton3.isEnabled = binding.checkBox1.isChecked || binding.checkBox2.isChecked || binding.checkBox3.isChecked
            binding.ChangeButton4.isEnabled = binding.checkBox1.isChecked || binding.checkBox2.isChecked || binding.checkBox3.isChecked
            binding.ChangeButton5.isEnabled = binding.checkBox1.isChecked || binding.checkBox2.isChecked || binding.checkBox3.isChecked

            if(binding.checkBox2.isChecked)
            {
                binding.checkBox1.isChecked = false
                binding.checkBox3.isChecked = false
            }
        }
        binding.checkBox3.setOnClickListener{

            binding.ChangeButton1.isEnabled = binding.checkBox1.isChecked || binding.checkBox2.isChecked || binding.checkBox3.isChecked
            binding.ChangeButton2.isEnabled = binding.checkBox1.isChecked || binding.checkBox2.isChecked || binding.checkBox3.isChecked
            binding.ChangeButton3.isEnabled = binding.checkBox1.isChecked || binding.checkBox2.isChecked || binding.checkBox3.isChecked
            binding.ChangeButton4.isEnabled = binding.checkBox1.isChecked || binding.checkBox2.isChecked || binding.checkBox3.isChecked
            binding.ChangeButton5.isEnabled = binding.checkBox1.isChecked || binding.checkBox2.isChecked || binding.checkBox3.isChecked

            if(binding.checkBox3.isChecked)
            {
                binding.checkBox1.isChecked = false
                binding.checkBox2.isChecked = false
            }
        }
    }
}