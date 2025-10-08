package com.example.cprogramming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView navigationView;
 private DrawerLayout drawerLayout;
 private NavigationView navigationView_drowar;
 private home home_fragment=new home();
 private Toolbar toolbar;

  private finding_output finding_output_fragment=new finding_output();
 private competitive_programming competitive_programming_fragment=new competitive_programming();
 private simple_program simple_program_fragment=new simple_program();
 private Quiz quiz_fragment=new Quiz();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView=findViewById(R.id.button_navigation);

        navigationView_drowar=findViewById(R.id.navigationApp);
        drawerLayout=findViewById(R.id.draw);
        toolbar=findViewById(R.id.toolbar);

        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar,R.string.close_drawer,R.string.open_drawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        navigationView_drowar.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.fram,home_fragment).commit();

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.home_menu){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fram,home_fragment).commit();
                    return true;
                } else if(item.getItemId() == R.id.simple_program_menu){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fram, simple_program_fragment).commit();Toast.makeText(MainActivity.this, "simple program", Toast.LENGTH_SHORT).show();
                    return true;
                } else if(item.getItemId() == R.id.finding_output_menu){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fram, finding_output_fragment).commit();
                    return true;
                } else if(item.getItemId() == R.id.competitive_menu){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fram, competitive_programming_fragment).commit();
                    return true;
                } else if(item.getItemId() == R.id.quiz_menu){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fram, quiz_fragment).commit();
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

   if(item.getItemId()==R.id.Profile){
       Intent intent=new Intent(MainActivity.this, Profile.class);
       startActivity(intent);
       return  true;
   }
       else if(item.getItemId()==R.id.history){
            Intent intent=new Intent(MainActivity.this, History.class);
            startActivity(intent);
            return  true;
        }
   else if(item.getItemId()==R.id.importance){
       Intent intent=new Intent(MainActivity.this, Application.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.hello){
       Intent intent=new Intent(MainActivity.this,Basic.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.include){
       Intent intent=new Intent(MainActivity.this,include.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.main){
       Intent intent=new Intent(MainActivity.this,mainFunction.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.return_type){
       Intent intent=new Intent(MainActivity.this,returnType.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.comment){
       Intent intent=new Intent(MainActivity.this,Comment.class);
       startActivity(intent);
       return  true;
   }

   else if(item.getItemId()==R.id.token){
       Intent intent=new Intent(MainActivity.this,Tokens.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.keyword){
       Intent intent=new Intent(MainActivity.this,Kywerd_Identifire.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.variable){
       Intent intent=new Intent(MainActivity.this,Variable.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.data_type){
       Intent intent=new Intent(MainActivity.this,DataType.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.initialization){
       Intent intent=new Intent(MainActivity.this,Declaretion.class);
       startActivity(intent);
       return  true;
   }

   else if(item.getItemId()==R.id.arithmetic){
       Intent intent=new Intent(MainActivity.this,Arithmetic.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.relational){
       Intent intent=new Intent(MainActivity.this,relationall.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.logical){
       Intent intent=new Intent(MainActivity.this,logical.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.increment){
       Intent intent=new Intent(MainActivity.this,increment.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.conditional){
       Intent intent=new Intent(MainActivity.this,conditional.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.bitwise){
       Intent intent=new Intent(MainActivity.this,bitwise.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.special){
       Intent intent=new Intent(MainActivity.this,special.class);
       startActivity(intent);
       return  true;
   }

   else if(item.getItemId()==R.id.operetors){
       Intent intent=new Intent(MainActivity.this,operators.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.expression_arithmetic){
       Intent intent=new Intent(MainActivity.this,expression_arithmetic.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.precedence){
       Intent intent=new Intent(MainActivity.this,precedence.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.convertion){
       Intent intent=new Intent(MainActivity.this,convertion.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.for_loop){
       Intent intent=new Intent(MainActivity.this,for_loos.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.while_loop){
       Intent intent=new Intent(MainActivity.this,while_loops.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.do_while){
       Intent intent=new Intent(MainActivity.this,do_while.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.nested){
       Intent intent=new Intent(MainActivity.this,nested_loops.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.one_array){
       Intent intent=new Intent(MainActivity.this,One_Dimensional_Array.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.two_array){
       Intent intent=new Intent(MainActivity.this,two_Dimensional_Array.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.multi_array){
       Intent intent=new Intent(MainActivity.this,Multi_Dimensional_Arrays.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.string){
       Intent intent=new Intent(MainActivity.this,string.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.introduction){
       Intent intent=new Intent(MainActivity.this,Introduction_function.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.multifunction){
       Intent intent=new Intent(MainActivity.this,multifunction.class);
       startActivity(intent);
       return  true;
   }

   else if(item.getItemId()==R.id.element){
       Intent intent=new Intent(MainActivity.this,element.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.function_call){
       Intent intent=new Intent(MainActivity.this,function_call.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.category){
       Intent intent=new Intent(MainActivity.this,category.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.nested_function){
       Intent intent=new Intent(MainActivity.this,nested_function.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.recursion){
       Intent intent=new Intent(MainActivity.this,recursion.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.pointers_Basic){
       Intent intent=new Intent(MainActivity.this,pointers_Basic.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.element_pointers){
       Intent intent=new Intent(MainActivity.this,element_pointers.class);
       startActivity(intent);
       return  true;
   }

   else if(item.getItemId()==R.id.pointer_function){
       Intent intent=new Intent(MainActivity.this,pointer_function.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.memory_allocation){
       Intent intent=new Intent(MainActivity.this,memory_allocation.class);
       startActivity(intent);
       return  true;
   }

   else if(item.getItemId()==R.id.structure){
       Intent intent=new Intent(MainActivity.this,structure.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.nested_structure){
       Intent intent=new Intent(MainActivity.this,nested_structure.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.union){
       Intent intent=new Intent(MainActivity.this,union.class);
       startActivity(intent);
       return  true;
   }

   else if(item.getItemId()==R.id.union_structure){
       Intent intent=new Intent(MainActivity.this,union_structure.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.basic_file){
       Intent intent=new Intent(MainActivity.this,basic_file.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id. file_operation){
       Intent intent=new Intent(MainActivity.this,file_operation.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.handling){
       Intent intent=new Intent(MainActivity.this,handling.class);
       startActivity(intent);
       return  true;
   }
   else if(item.getItemId()==R.id.interview){
       Intent intent=new Intent(MainActivity.this,handling.class);
       startActivity(intent);
       return  true;
   }
        return false;
    }
}