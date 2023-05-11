package com.example.kursach.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kursach.Adapter.CategoryAdapter;
import com.example.kursach.Adapter.ItemsAdapter;
import com.example.kursach.Adapter.PriceAdapter;
import com.example.kursach.Adapter.RecommendedAdapter;
import com.example.kursach.Domain.CategoryDomain;
import com.example.kursach.Domain.ItemsDomain;
import com.example.kursach.Domain.OrderDomain;
import com.example.kursach.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPopular, adapterNew;
    private RecyclerView recyclerViewPopular, recyclerViewNew;
    private RecyclerView recyclerViewCategoryList,productRecycler,recyclerViewPopularList;
    static ArrayList<OrderDomain> orderlist = new ArrayList<>();
    static    ArrayList<CategoryDomain> categoryList = new ArrayList<>();
    static ArrayList<OrderDomain> fullOrderlist = new ArrayList<>();
    static PriceAdapter priceAdapter;
    private RecyclerView.Adapter adapter, adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCategory();
        recyclerViewPopular();
        setProductRecycler(orderlist);
        fullOrderlist.addAll(orderlist);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);



        categoryList.add(new CategoryDomain("Памятники", "cat_5",5));
        categoryList.add(new CategoryDomain("Заповедники", "cat_8",2));
        categoryList.add(new CategoryDomain("Парки", "cat_9",3));
        categoryList.add(new CategoryDomain("Музеи", "cat_10",4));



        adapter =new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);

    }
    private void setProductRecycler(ArrayList<OrderDomain> productList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);

        productRecycler = findViewById(R.id.ProductRecycler);
        productRecycler.setLayoutManager(layoutManager);
        priceAdapter = new PriceAdapter(this, productList);
        productRecycler.setAdapter(priceAdapter);

        productRecycler.setHasFixedSize(true);

    }
    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);



        orderlist.add(new OrderDomain("Памятник Затопленным кораблям", "Севастополь", "Памятник является символом города Севастополь, а его силуэт воспроизведен на эмблеме города. " +
                "Он создан в память о российских парусных кораблях, " +
                "затопленных в бухте с целью загородить вражеским кораблям проезд в бухту.", 2, 1, 0, "pic3", true,5));
        orderlist.add(new OrderDomain("Карадагский заповедник", "г. Феодосия, пгт Курортное, ул.Науки, 24", "Неподалеку от Феодосии расположен удивительный заповедник, " +
                "с которым связано немало легенд. Карадагский заповедник, занимающий территорию в более чем 2870 га, был основан в 1979 году" +
                "Чтобы уникальная природа не была разрушена, было принято решение об основании природного заповедника. Со времени основания фауна и флора Карадагского заповедника были восстановлены в значительной мере. " +
                "125 видов животных, обитающих на склонах горного массива, 79 видов растений занесены в Красную книгу.", 3, 1, 600, "pic5", false,2));
        orderlist.add(new OrderDomain("Юбилейный парк", "г. Феодосия, ул. Горького, 3", "В парке Юбилейный на относительно маленькой площади расположено большое число исторических и архитектурных памятников, " +
                "оборудованы красивейшие цветочные клумбы, а его месторасположение в самом центре города, неподалеку от морского порта и железнодорожной станции «Феодосия», " +
                "делает парк очень удобным для посещения.", 2, 1, 0, "pic6", true,3));
        orderlist.add(new OrderDomain("Воронцовский дворец", "г. Алупка, ул. Дворцовое шоссе", "Воронцовский дворец в Алупке (Крым) по праву считается одной из жемчужин полуострова. " +
                "Изящное и, в то же время, величественное строение расположено у подножия горы Ай-Петри. " +
                "Его окружает уникальный парковый комплекс, а с парадной лестницы открывается удивительный вид на Черное море. Дворцовый комплекс органично вписывается в окружающий ландшафт благодаря тому, что его расположение соответствует горному рельефу. " +
                "Именно поэтому дворец имеет такой оригинальный образ. Воронцовский дворец в Крыму и прилегающий к нему парк часто становились съемочной площадкой.", 3, 1, 1000, "pic7", false,4));



        adapter2 = new RecommendedAdapter(orderlist);
        recyclerViewPopularList.setAdapter(adapter2);



    }


    public static void showOrderByCategory(int category){
        orderlist.clear();
        orderlist.addAll(fullOrderlist);
        List<OrderDomain> filterOrder = new ArrayList<>();
        for(OrderDomain c: fullOrderlist){
            if(c.getCat_id()==category)
                filterOrder.add(c);
        }

        orderlist.clear();
        orderlist.addAll(filterOrder);
        priceAdapter.notifyDataSetChanged();
    }
}