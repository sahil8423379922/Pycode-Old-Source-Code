package com.priyanka.pycode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.priyanka.pycode.R;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class showBookmark extends AppCompatActivity {

    Bookmark mydatabase;
    String value;
    TextView show;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bookmark);

        Toolbar toolbar = findViewById(R.id.bookmark_toolbar);
        setSupportActionBar(toolbar);
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3774908939242242/5917946717");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        final ListView listView = (ListView) findViewById(R.id.listview);
        mydatabase = new Bookmark(this);

        final ArrayList<String> thelist = new ArrayList<>();
        Cursor data = mydatabase.getAlldata();
        if (data.getCount() == 0) {
            Toast.makeText(this, "No Bookmark", Toast.LENGTH_SHORT).show();
        } else {
            while (data.moveToNext()) {
                thelist.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                listView.setAdapter(listAdapter);
            }

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    String value = ((TextView) view).getText().toString();
                    Toast.makeText(getApplicationContext(), value,
                            Toast.LENGTH_SHORT).show();

                    if (value.equals("Introduction to Python")) {
                        startActivity(new Intent(showBookmark.this, introduction_to_python.class));
                    }

                    if (value.equals("Accessing List Element")) {
                        startActivity(new Intent(showBookmark.this, Acessing_Element.class));
                    }

                    if (value.equals("Accessing Tuple Element")) {
                        startActivity(new Intent(showBookmark.this, AcessingTuple.class));
                    }

                    if (value.equals("Airthmetic Operator")) {
                        startActivity(new Intent(showBookmark.this, AirthemeticOperator.class));
                    }

                    if (value.equals("Algorithm")) {
                        startActivity(new Intent(showBookmark.this, Algorithm.class));
                    }

                    if (value.equals("Anonymous Function")) {
                        startActivity(new Intent(showBookmark.this, AnonymousFunction.class));
                    }

                    if (value.equals("Appendng value in Dictionary")) {
                        startActivity(new Intent(showBookmark.this, Appendingvalues.class));
                    }

                    if (value.equals("Assignment Operator")) {
                        startActivity(new Intent(showBookmark.this, AssignmentOperator.class));
                    }

                    if (value.equals("Basic Operation in Dictionary")) {
                        startActivity(new Intent(showBookmark.this, BasicOperation.class));
                    }

                    if (value.equals("Bitwise Operator")) {
                        startActivity(new Intent(showBookmark.this, BitwiseOperator.class));
                    }


                    if (value.equals("Break")) {
                        startActivity(new Intent(showBookmark.this, Break.class));
                    }

                    if (value.equals("Calling Function")) {
                        startActivity(new Intent(showBookmark.this, CallingFuction.class));
                    }

                    if (value.equals("Continue Statement")) {
                        startActivity(new Intent(showBookmark.this, Continue.class));
                    }

                    if (value.equals("Creating List in Python")) {
                        startActivity(new Intent(showBookmark.this, Creating_a_List.class));
                    }


                    if (value.equals("Creating Function in Python")) {
                        startActivity(new Intent(showBookmark.this, Creating_a_List.class));
                    }

                    if (value.equals("Datatype")) {
                        startActivity(new Intent(showBookmark.this, Datatype.class));
                    }

                    if (value.equals("Delimeters")) {
                        startActivity(new Intent(showBookmark.this, Delimeters.class));
                    }


                    if (value.equals("Dynamic Allocation")) {
                        startActivity(new Intent(showBookmark.this, Delimeters.class));
                    }


                    if (value.equals("Exception Clause")) {
                        startActivity(new Intent(showBookmark.this, ExceptionClause.class));
                    }

                    if (value.equals("Exception Handling")) {
                        startActivity(new Intent(showBookmark.this, Exception_handling.class));
                    }

                    if (value.equals("For Loop")) {
                        startActivity(new Intent(showBookmark.this, ForLoop.class));
                    }

                    if (value.equals("Function and Methods")) {
                        startActivity(new Intent(showBookmark.this, FunctionsandMethods.class));
                    }

                    if (value.equals("Function Arguments")) {
                        startActivity(new Intent(showBookmark.this, FunctionArguments.class));
                    }



                    if (value.equals("Methods in tuple")) {
                        startActivity(new Intent(showBookmark.this, FunctionsandMethodstuple.class));
                    }

                    if (value.equals("Global and Local Variable")) {
                        startActivity(new Intent(showBookmark.this, GlobalandLocalVariable.class));
                    }

                    if (value.equals("if condition in Python")) {
                        startActivity(new Intent(showBookmark.this, If_condition.class));
                    }


                    if (value.equals("if else condition in Python")) {
                        startActivity(new Intent(showBookmark.this, If_else_condition.class));
                    }

                    if (value.equals("Importing Module in Python")) {
                        startActivity(new Intent(showBookmark.this, ImportingModule.class));
                    }


                    if (value.equals("Indentation in Python")) {
                        startActivity(new Intent(showBookmark.this, Indentation.class));
                    }

                    if (value.equals("Input in Python")) {
                        startActivity(new Intent(showBookmark.this, Input.class));
                    }

                    if (value.equals("Input in Python")) {
                        startActivity(new Intent(showBookmark.this, Input.class));
                    }

                    if (value.equals("Installation of Python")) {
                        startActivity(new Intent(showBookmark.this, Installation_puthon.class));
                    }


                    if (value.equals("Interpreter")) {
                        startActivity(new Intent(showBookmark.this,Interpreter.class));
                    }

                    if (value.equals("Intialising a String")) {
                        startActivity(new Intent(showBookmark.this, Intialising_String.class));
                    }


                    if (value.equals("Keywords")) {
                        startActivity(new Intent(showBookmark.this, Keywords.class));
                    }

                    if (value.equals("Methods in List")) {
                        startActivity(new Intent(showBookmark.this, list_function_and_methods.class));
                    }

                    if (value.equals("List in Python")) {
                        startActivity(new Intent(showBookmark.this, list_function_and_methods.class));
                    }

                    if (value.equals("Math Module")) {
                        startActivity(new Intent(showBookmark.this, Mathmodule.class));
                    }

                    if (value.equals("Merging in Dictionary")) {
                        startActivity(new Intent(showBookmark.this, Merging.class));
                    }


                    if (value.equals("Modules in Python")) {
                        startActivity(new Intent(showBookmark.this, ModulesinPython.class));
                    }

                    if (value.equals("Nested Condition")) {
                        startActivity(new Intent(showBookmark.this, Nested_condition.class));
                    }

                    if (value.equals("Nested Loop")) {
                        startActivity(new Intent(showBookmark.this, NestedLoop.class));
                    }

                    if (value.equals("Operation on List")) {
                        startActivity(new Intent(showBookmark.this, Operation_on_List.class));
                    }

                    if (value.equals("Other Operator")) {
                        startActivity(new Intent(showBookmark.this, OtherOperator.class));
                    }

                    if (value.equals("Output in Python")) {
                        startActivity(new Intent(showBookmark.this, Output.class));
                    }

                    if (value.equals("Packages in Python")) {
                        startActivity(new Intent(showBookmark.this, Packages.class));
                    }


                    if (value.equals("Pass Statement")) {
                        startActivity(new Intent(showBookmark.this, Pass.class));
                    }

                    if (value.equals("Programming Methodology")) {
                        startActivity(new Intent(showBookmark.this, ProgrammingMethodoloy.class));
                    }

                    if (value.equals("Random Module")) {
                        startActivity(new Intent(showBookmark.this, RandomModule.class));
                    }

                    if (value.equals("Relational Operator")) {
                        startActivity(new Intent(showBookmark.this, RelationalOperatoe.class));
                    }

                    if (value.equals("Removing Item in Dictionary")) {
                        startActivity(new Intent(showBookmark.this,RemovinganItem.class));
                    }

                    if (value.equals("Software Concepts")) {
                        startActivity(new Intent(showBookmark.this,software_concepts.class));
                    }

                    if (value.equals("String in Python")) {
                        startActivity(new Intent(showBookmark.this,String_in_python.class));
                    }


                    if (value.equals("String Slices")) {
                        startActivity(new Intent(showBookmark.this,String_Slices.class));
                    }

                    if (value.equals("While Loop")) {
                        startActivity(new Intent(showBookmark.this,whileLoop.class));
                    }

                    if (value.equals("Variable")) {
                        startActivity(new Intent(showBookmark.this,Variable.class));
                    }



                    if (value.equals("Types of Function")) {
                        startActivity(new Intent(showBookmark.this,TypesofFunction.class));
                    }

                    if (value.equals("Type conversion")) {
                        startActivity(new Intent(showBookmark.this,Typeconversion.class));
                    }

                    if (value.equals("Tuple in Python")) {
                        startActivity(new Intent(showBookmark.this,TupleinPython.class));
                    }

                    if (value.equals("Traversing in Python")) {
                        startActivity(new Intent(showBookmark.this,Traversing.class));
                    }

                    if (value.equals("Tokens in Python")) {
                        startActivity(new Intent(showBookmark.this,Tokens.class));
                    }

                    if (value.equals("Dictionary python")) {
                        startActivity(new Intent(showBookmark.this,DictionaryPython.class));
                    }
                    if (value.equals("Methods in Dictionary")) {
                        startActivity(new Intent(showBookmark.this,FunctionsandMethods.class));
                    }
                    if (value.equals("Printing Dictionary in python")) {
                        startActivity(new Intent(showBookmark.this,intro_of_dictionary.class));

                     }






                }
            });

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.deletebookmark, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.delete) {
            mydatabase.delete();
            finish();
            overridePendingTransition(0, 0);
            startActivity(getIntent());
            overridePendingTransition(0, 0);
            Toast.makeText(this, "Bookmark Deleted", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
