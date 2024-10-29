package com.example.bai3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bai3.adapter.StudentAdapter
import com.example.bai3.model.Student

class MainActivity : AppCompatActivity() {

    private lateinit var editTextSearch: EditText
    private lateinit var recyclerViewStudents: RecyclerView
    private lateinit var studentAdapter: StudentAdapter
    private lateinit var studentsList: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextSearch = findViewById(R.id.editTextSearch)
        recyclerViewStudents = findViewById(R.id.recyclerViewStudents)


        studentsList = listOf(
            Student("Nguyen Van Truong", "20215496"),
            Student("Le Thi B", "20215894"),
            Student("Tran Van C", "20214838"),
            Student("Pham Thi D", "20203818"),
            Student("Vo Van E", "20181293"),
            Student("Le Thi F", "20203818"),
            Student("Nguyen Thi G", "20203818"),
            Student("Pham Van H", "20203818"),
            Student("Do Gia K", "20203818"),
            Student("Tran Duc M", "20203818"),
            Student("Tran Van N", "20203818"),
            Student("Le Thanh O", "20203818"),
            Student("Pham Thi S", "20203818"),
            Student("Pham Thi Q", "20203818"),
            Student("Pham Thi R", "20203818"),
            Student("Pham Thi T", "20203818"),
            Student("Pham Thi P", "20203818"),
        )

        // Thiết lập RecyclerView và Adapter
        studentAdapter = StudentAdapter(studentsList)
        recyclerViewStudents.layoutManager = LinearLayoutManager(this)
        recyclerViewStudents.adapter = studentAdapter

        // Thiết lập chức năng tìm kiếm
        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim()
                if (query.length > 2) {
                    filterStudents(query)
                } else {
                    studentAdapter.updateData(studentsList) // Hiện lại toàn bộ danh sách
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun filterStudents(query: String) {
        val filteredList = studentsList.filter {
            it.name.contains(query, ignoreCase = true) || it.studentId.contains(query, ignoreCase = true)
        }
        studentAdapter.updateData(filteredList)
    }
}
