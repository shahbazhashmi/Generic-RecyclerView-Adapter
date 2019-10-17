## Generic-RecyclerView-Adapter

### Introduction

**Generic RecyclerView Adapter** is a generic implementation of RecyclerView Adapter. By using this we don't need to create multiple adapters.

<br>

### Usage

1. Create adapter object

```markdown
lateinit var testAdapter: GenericAdapter<TestModel>
```

2. Instantiate adapter object (pass context, layout and Binder object).

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
