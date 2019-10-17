## Generic-RecyclerView-Adapter

### Introduction

**Generic RecyclerView Adapter** is a generic implementation of RecyclerView Adapter. By using this we don't need to create multiple adapters.

<br>

### Usage

1. Create adapter object

```markdown
lateinit var testAdapter: GenericAdapter<TestModel>
```

2. Instantiate adapter object (pass context, layout, list and Binder object in the constructor).

**Set your layout data within bind method**

```
testAdapter = GenericAdapter(this, R.layout.row_test, animalList, object :  GenericAdapter.Binder<TestModel> {
            override fun bind(holder: GenericAdapter<TestModel>.ViewHolder, position: Int) {
                holder.itemView.findViewById<TextView>(R.id.test_tv).setText((testAdapter.getItem(position) as TestModel).text)

                holder.itemView.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You clicked " + (testAdapter.getItem(position) as TestModel).text + " on row number " + position, Toast.LENGTH_SHORT).show()
                }
            }
        })
```

3. Implementation

**MainActivity**

```
package matrixsystems.genericrecyclerviewadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView

    lateinit var testAdapter: GenericAdapter<TestModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val animalList = mutableListOf<TestModel>()
        animalList.add(TestModel("Horse"))
        animalList.add(TestModel("Cow"))
        animalList.add(TestModel("Camel"))
        animalList.add(TestModel("Sheep"))
        animalList.add(TestModel("Goat"))

        recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        testAdapter = GenericAdapter(this, R.layout.row_test, animalList, object :  GenericAdapter.Binder<TestModel> {
            override fun bind(holder: GenericAdapter<TestModel>.ViewHolder, position: Int) {
                holder.itemView.findViewById<TextView>(R.id.test_tv).setText((testAdapter.getItem(position) as TestModel).text)

                holder.itemView.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You clicked " + (testAdapter.getItem(position) as TestModel).text + " on row number " + position, Toast.LENGTH_SHORT).show()
                }
            }
        })
        recyclerView.adapter = testAdapter
    }

}

```
