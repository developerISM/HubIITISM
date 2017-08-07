package io.github.gitwebx.hubiitism;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ContactsActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private RecyclerView recyclerView;
    private ContactsAdapter adapter;
    private List<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        contactList = new ArrayList<>();
        adapter = new ContactsAdapter(this, contactList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();


//        try {
//            Glide.with(this).load(R.drawable.phone).into((ImageView) findViewById(R.id.backdrop));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
//    private void initCollapsingToolbar() {
//        final CollapsingToolbarLayout collapsingToolbar =
//                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
//        collapsingToolbar.setTitle(" ");
//        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
//        appBarLayout.setExpanded(true);
//
//        // hiding & showing the title when toolbar expanded & collapsed
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            boolean isShow = false;
//            int scrollRange = -1;
//
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (scrollRange == -1) {
//                    scrollRange = appBarLayout.getTotalScrollRange();
//                }
//                if (scrollRange + verticalOffset == 0) {
//                    collapsingToolbar.setTitle(getString(R.string.app_name));
//                    isShow = true;
//                } else if (isShow) {
//                    collapsingToolbar.setTitle(" ");
//                    isShow = false;
//                }
//            }
//        });
//    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.c1,
                R.drawable.c2,
                R.drawable.c3,
                R.drawable.c4,
                R.drawable.c5,
                R.drawable.c6,
                R.drawable.c7,
                R.drawable.c8,
                R.drawable.c9,
                R.drawable.c10,
                R.drawable.c11,
                R.drawable.c12,
                R.drawable.c13,
                R.drawable.c14,
                R.drawable.c15,
                R.drawable.c16,
                R.drawable.c17,
                R.drawable.c18,
                R.drawable.c19,
                R.drawable.c20,
                R.drawable.c21,
                R.drawable.c22,
                R.drawable.c23,
                R.drawable.c24,
                R.drawable.c25,
                R.drawable.c26,
                R.drawable.c27,
                R.drawable.c28,
                R.drawable.c29,
                R.drawable.c30,
                R.drawable.c31,
                R.drawable.c32,
                R.drawable.c33,
                R.drawable.c34,
                R.drawable.c35,
                R.drawable.c36,
                R.drawable.c37,
                R.drawable.c38,
                R.drawable.c39,
                R.drawable.c40,
                R.drawable.c41,
                R.drawable.c42,
                R.drawable.c43,
                R.drawable.c44,
                R.drawable.c45,
                R.drawable.c46,
                R.drawable.c47,
                R.drawable.c48,
                R.drawable.c49,
                R.drawable.c50,
                R.drawable.c51,
                R.drawable.c52,
                R.drawable.c53,
                R.drawable.c54,
                R.drawable.c55,
                R.drawable.c56,
                R.drawable.c57,
                R.drawable.c58,
                R.drawable.c59,
                R.drawable.c60,
                R.drawable.c61,
                R.drawable.c62,
                R.drawable.c63,
                R.drawable.c64,
                R.drawable.c65,
                R.drawable.c66,
                R.drawable.c67,
                R.drawable.c68,
                R.drawable.c69,
                R.drawable.c70,
                R.drawable.c71,
                R.drawable.c72,
                R.drawable.c73,
                R.drawable.c74,
                R.drawable.c75,
                R.drawable.c76,
                R.drawable.c77,
                R.drawable.c78,
                R.drawable.c79,
                R.drawable.c80,
                R.drawable.c81,
                R.drawable.c82,
                R.drawable.c83,
                R.drawable.c84,
                R.drawable.c85,
                R.drawable.c86,
                R.drawable.c87,
                R.drawable.c88,
                R.drawable.c89,
                R.drawable.c90,
                R.drawable.c91,
                R.drawable.c92,
                R.drawable.c93,
                R.drawable.c94,
                R.drawable.c95,
                R.drawable.c96,
                R.drawable.c97,
                R.drawable.c98,
                R.drawable.c99,
                R.drawable.c100,
                R.drawable.c101,
                R.drawable.c102,
                R.drawable.c103,
                R.drawable.c104,
                R.drawable.c105,
                R.drawable.c106,
                R.drawable.c107,
                R.drawable.c108,
                R.drawable.c109,
                R.drawable.c110,
                R.drawable.c111,
                R.drawable.c112,
                R.drawable.c113,
                R.drawable.c114,
                R.drawable.c115,
                R.drawable.c116,
                R.drawable.c117,
                R.drawable.c118,
                R.drawable.c119,
                R.drawable.c120,
                R.drawable.c121,
                R.drawable.c122,
                R.drawable.c123,
                R.drawable.c124,
                R.drawable.c125,
                R.drawable.c126,
                R.drawable.c127,
                R.drawable.c128,
                R.drawable.c129,
                R.drawable.c130,
                R.drawable.c131,
                R.drawable.c132,
                R.drawable.c133,
                R.drawable.c134,
                R.drawable.c135,
                R.drawable.c136,
                R.drawable.c137,
                R.drawable.c138,
                R.drawable.c139,
                R.drawable.c140,
                R.drawable.c141,
                R.drawable.c142,
                R.drawable.c143,
                R.drawable.c144,
                R.drawable.c145,
                R.drawable.c146,
                R.drawable.c147,
                R.drawable.c148,
                R.drawable.c149,
                R.drawable.c150,
                R.drawable.c151,
                R.drawable.c152,
                R.drawable.c153,
                R.drawable.c154,
                R.drawable.c155,
                R.drawable.c156,
                R.drawable.c157,
                R.drawable.c158,
                R.drawable.c159,
                R.drawable.c160,
                R.drawable.c161,
                R.drawable.c162,
                R.drawable.c163,
                R.drawable.c164,
                R.drawable.c165,
                R.drawable.c166,
                R.drawable.c167,
                R.drawable.c168,
                R.drawable.c169,
                R.drawable.c170,
                R.drawable.c171,
                R.drawable.c172,
                R.drawable.c173,
                R.drawable.c174,
                R.drawable.c175,
                R.drawable.c176,
                R.drawable.c177,
                R.drawable.c178,
                R.drawable.c179,
                R.drawable.c180,
                R.drawable.c181,
                R.drawable.c182,
                R.drawable.c183,
                R.drawable.c184,
                R.drawable.c185,
                R.drawable.c186,
                R.drawable.c187,
                R.drawable.c188,
                R.drawable.c189,
                R.drawable.c190,
                R.drawable.c191,
                R.drawable.c192,
                R.drawable.c193,
                R.drawable.c194,
                R.drawable.c195,
                R.drawable.c196,
                R.drawable.c197,
                R.drawable.c198,
                R.drawable.c199,
                R.drawable.c200,
                R.drawable.c201,
                R.drawable.c202,
                R.drawable.c203,
                R.drawable.c204,
                R.drawable.c205,
                R.drawable.c206,
                R.drawable.c207,
                R.drawable.c208,
                R.drawable.c209,
                R.drawable.c210,
                R.drawable.c211,
                R.drawable.c212,
                R.drawable.c213,
                R.drawable.c214,
                R.drawable.c215,
                R.drawable.c216,
                R.drawable.c217,
                R.drawable.c218,
                R.drawable.c219,
                R.drawable.c220,
                R.drawable.c221,
                R.drawable.c222,
                R.drawable.c223,
                R.drawable.c224,
                R.drawable.c225,
                R.drawable.c226,
                R.drawable.c227,
                R.drawable.c228,
                R.drawable.c229,
                R.drawable.c230,
                R.drawable.c231,
                R.drawable.c232,
                R.drawable.c233,
                R.drawable.c234,
                R.drawable.c235,
                R.drawable.c236,
                R.drawable.c237,
                R.drawable.c238,
                R.drawable.c239,
                R.drawable.c240,
                R.drawable.c241,
                R.drawable.c242,
                R.drawable.c243,
                R.drawable.c244,
                R.drawable.c245,
                R.drawable.c246,
                R.drawable.c247,
                R.drawable.c248,
                R.drawable.c249,
                R.drawable.c250,
                R.drawable.c251,
                R.drawable.c252,
                R.drawable.c253,
                R.drawable.c254,
                R.drawable.c255,
                R.drawable.c256,
                R.drawable.c257,
                R.drawable.c258,
                R.drawable.c259,
                R.drawable.c260,
                R.drawable.c261,
                R.drawable.c262,
                R.drawable.c263,
                R.drawable.c264,
                R.drawable.c265,
                R.drawable.c266,
                R.drawable.c267,
                R.drawable.c268,
                R.drawable.c269,
                R.drawable.c270,
                R.drawable.c271,
                R.drawable.c272,
                R.drawable.c273,
                R.drawable.c274,
                R.drawable.c275,
                R.drawable.c276,
                R.drawable.c277,
                R.drawable.c278,
                R.drawable.c279,
                R.drawable.c280,
                R.drawable.c281,
                R.drawable.c282,
                R.drawable.c283,
                R.drawable.c284,
                R.drawable.c285,
                R.drawable.c286,
                R.drawable.c287,
                R.drawable.c288
                };

        Contact a = new Contact("AK Mukhopadhyay", "+913262296563", covers[0]);
        contactList.add(a);
        a = new Contact("AK Pathak", "+913262206312", covers[1]);
        contactList.add(a);
        a = new Contact("AS Venkatesh", "+919431125801", covers[2]);
        contactList.add(a);
        a = new Contact("A Sarkar", "+919430335255", covers[3]);
        contactList.add(a);
        a = new Contact("A tarachand", "+919471191420", covers[4]);
        contactList.add(a);
        a = new Contact("AK Mishra", "+913262235452", covers[5]);
        contactList.add(a);
        a = new Contact("AK Samanta", "+913262235087", covers[6]);
        contactList.add(a);
        a = new Contact("Abhi Rani", "+913262235492", covers[7]);
        contactList.add(a);
        a = new Contact("Abhay Kumar Singh", "+913262235670", covers[8]);
        contactList.add(a);
        a = new Contact("Abhishek Kumar Singh", "+913262235118", covers[9]);
        contactList.add(a);
        a = new Contact("Ajay Mandal", "+919431711017", covers[10]);
        contactList.add(a);
        a = new Contact("Ajit Kumar", "+919471192264", covers[11]);
        contactList.add(a);
        a = new Contact("Ajit Kumar Behura", "9234604362", covers[12]);
        contactList.add(a);
        a = new Contact("Ajoy Kumar Bhaumik", "3262296616", covers[13]);
        contactList.add(a);
        a = new Contact("Aju Aravind", "9431121114", covers[14]);
        contactList.add(a);
        a = new Contact("Akhilesh Prasad", "9431711231	", covers[15]);
        contactList.add(a);
        a = new Contact("Alok Kumar Das", "9471191234", covers[16]);
        contactList.add(a);
        a = new Contact("Alok Sinha", "9471518560", covers[17]);
        contactList.add(a);
        a = new Contact("Alok Sinha", "9471518560", covers[18]);
        contactList.add(a);
        a = new Contact("Amares Chaudhary", "9431121859", covers[19]);
        contactList.add(a);
        a = new Contact("Amit Kumar Verma", "7781012407", covers[20]);
        contactList.add(a);
        a = new Contact("Amit Rai Dixit", "9430133003", covers[21]);
        contactList.add(a);
        a = new Contact("Amitava mandal", "9471191826", covers[22]);
        contactList.add(a);
        a = new Contact("Amitesh Kumar", "3262235759", covers[23]);
        contactList.add(a);
        a = new Contact("Anand Anupam", "3262235922", covers[24]);
        contactList.add(a);
        a = new Contact("Ananda Shankar Hati", "9471191571", covers[25]);
        contactList.add(a);
        a = new Contact("Anil Kumar Nirala", "9431125123", covers[26]);
        contactList.add(a);
        a = new Contact("Annavarpu Chandra Sekhara Rao", "3262235420", covers[27]);
        contactList.add(a);
        a = new Contact("Anshumali", "9934556176", covers[28]);
        contactList.add(a);
        a = new Contact("Anup Krishna Prasad", "9471192451", covers[29]);
        contactList.add(a);
        a = new Contact("Anurag Jayaswal", "9431122002", covers[30]);
        contactList.add(a);
        a = new Contact("Archana", "9471191527", covers[31]);
        contactList.add(a);
        a = new Contact("Arijit Barpal", "3262235151	", covers[32]);
        contactList.add(a);
        a = new Contact("Arup Kumar Pal", "9470985812", covers[33]);
        contactList.add(a);
        a = new Contact("Ashis Mallick", "9471192246", covers[34]);
        contactList.add(a);
        a = new Contact("Ashok Kumar Singh", "8130733447", covers[35]);
        contactList.add(a);
        a = new Contact("Ashutosh Kumar", "9430109007", covers[36]);
        contactList.add(a);
        a = new Contact("Asim Kumar Pal", "9939160256", covers[37]);
        contactList.add(a);
        a = new Contact("Asit Kumar Kar", "3262234503", covers[38]);
        contactList.add(a);
        a = new Contact("Atul K.Varma", "3262235449", covers[39]);
        contactList.add(a);
        a = new Contact("B. Krishna Naick", "326223654", covers[40]);
        contactList.add(a);
        a = new Contact("Badam Singh Kushvah", "3265765 (I)", covers[41]);
        contactList.add(a);
        a = new Contact("Bani Mukherjee", "9431125407		", covers[42]);
        contactList.add(a);
        a = new Contact("Barun Kumar Nandi", "9471192317", covers[43]);
        contactList.add(a);
        a = new Contact("Bhabesh C. Sakar", "9431121653", covers[44]);
        contactList.add(a);
        a = new Contact("Bhanwar S. Choudhary", "9471191374", covers[45]);
        contactList.add(a);
        a = new Contact("Bibhas Chandra", "7766907803", covers[46]);
        contactList.add(a);
        a = new Contact("Binata Panda", "8877169589", covers[47]);
        contactList.add(a);
        a = new Contact("Biplab Bhattacharya", "3262235418", covers[48]);
        contactList.add(a);
        a = new Contact("Biswajit Paul", "9431125959", covers[49]);
        contactList.add(a);
        a = new Contact("Bobby Antony", "9470194795", covers[50]);
        contactList.add(a);
        a = new Contact("Brijesh Kumar Mishra", "3262235752", covers[51]);
        contactList.add(a);
        a = new Contact("ChanchalHalder", "9471192182", covers[52]);
        contactList.add(a);
        a = new Contact("Chandan Bhar", "3262235434", covers[53]);
        contactList.add(a);
        a = new Contact("Chandan Guria", "9431326774", covers[54]);
        contactList.add(a);
        a = new Contact("Chirajeev Kumar", "9431125793", covers[55]);
        contactList.add(a);
        a = new Contact("Chiranjib Banerjee", "9955005111", covers[56]);
        contactList.add(a);
        a = new Contact("D N V V Konda Lutukurthi", "3262235907", covers[57]);
        contactList.add(a);
        a = new Contact("D. C. Panigrahi", "3262235235", covers[58]);
        contactList.add(a);
        a = new Contact("D. D. Pathak", "3262235459", covers[59]);
        contactList.add(a);
        a = new Contact("D. Krishna Sandilya", "3262235066", covers[60]);
        contactList.add(a);
        a = new Contact("D. P. Mishra", "9430191673", covers[61]);
        contactList.add(a);
        a = new Contact("Debjani Mitra", "3262206866", covers[62]);
        contactList.add(a);
        a = new Contact("Deepak Kumar Mandal", "3262235058", covers[63]);
        contactList.add(a);
        a = new Contact("Deepanker Asthana", "3262235424", covers[64]);
        contactList.add(a);
        a = new Contact("Devendra Chack", "9471191821", covers[65]);
        contactList.add(a);
        a = new Contact("Dharvath Ramesh", "9471191814", covers[66]);
        contactList.add(a);
        a = new Contact("Dheeraj Kumar", "9431711199", covers[67]);
        contactList.add(a);
        a = new Contact("Dinabandhu Pradhan", "7070996650", covers[68]);
        contactList.add(a);
        a = new Contact("Dinkar Brajeshkumar Kishorilal", "9471191871", covers[69]);
        contactList.add(a);
        a = new Contact("Partha Sarati Gupta", "3262235236", covers[70]);
        contactList.add(a);
        a = new Contact("Basanta Bandhuri", "3262235181", covers[71]);
        contactList.add(a);
        a = new Contact("Biswajit Chowdhary", "9470194350", covers[72]);
        contactList.add(a);
        a = new Contact("P.M.Sarun", "9471191816", covers[73]);
        contactList.add(a);
        a = new Contact("Prashant Kumar Sharma", "9471191339", covers[74]);
        contactList.add(a);
        a = new Contact("B. Thangvel", "9471191337", covers[75]);
        contactList.add(a);
        a = new Contact("Ram Bilash Choudhary", "2362235881", covers[76]);
        contactList.add(a);
        a = new Contact("S.K. Padhi", "3262235114", covers[77]);
        contactList.add(a);
        a = new Contact("Sagar Pal", "9471191529", covers[78]);
        contactList.add(a);
        a = new Contact("Umakanta Tripathy", "9471192489", covers[79]);
        contactList.add(a);
        a = new Contact("Vinod Kumar Singh", "9471191037", covers[80]);
        contactList.add(a);
        a = new Contact("G Srinivasa Rao", "", covers[81]);
        contactList.add(a);
        a = new Contact("G.N. Singh", "9431711004", covers[82]);
        contactList.add(a);
        a = new Contact("G.P. Biswas", "9431124198", covers[83]);
        contactList.add(a);
        a = new Contact("G. UdayaBhanu", "3262235461	", covers[84]);
        contactList.add(a);
        a = new Contact("Gajendra Kumar Vishwakarma", "9471191338", covers[85]);
        contactList.add(a);
        a = new Contact("Ganesh Chandra NAyak", "3262235934", covers[86]);
        contactList.add(a);
        a = new Contact("Gauri Shankar", "3262235633", covers[87]);
        contactList.add(a);
        a = new Contact("Gaur Shanker Seth", "9006482450", covers[88]);
        contactList.add(a);
        a = new Contact("Gyananadh Budi", "9471191408", covers[89]);
        contactList.add(a);
        a = new Contact("Govind Murmu", "3262296622", covers[90]);
        contactList.add(a);
        a = new Contact("Govind Swaroop Pathak", "3262235481", covers[91]);
        contactList.add(a);
        a = new Contact("Gurdeep Singh", "2362296624", covers[92]);
        contactList.add(a);
        a = new Contact("Gyan Prakash", "9771439583	", covers[93]);
        contactList.add(a);
        a = new Contact("Haider Banka", "9471191233", covers[94]);
        contactList.add(a);
        a = new Contact("Hari Om", "3262235638", covers[95]);
        contactList.add(a);
        a = new Contact("Hari Pada Nayek", "3262235756", covers[96]);
        contactList.add(a);
        a = new Contact("Hemant Kumae", "9431964128", covers[97]);
        contactList.add(a);
        a = new Contact("Indra MAni Mishra", "no. mb", covers[98]);
        contactList.add(a);
        a = new Contact("J.K. Pattnayak", "9431122309", covers[99]);
        contactList.add(a);
        a = new Contact("Jairam Manam ", "9471192138", covers[100]);
        contactList.add(a);
        a = new Contact("Jaisingh T", "9471191822", covers[101]);
        contactList.add(a);
        a = new Contact("Jayanta Das", "9471191639", covers[102]);
        contactList.add(a);
        a = new Contact("Jhasketan Nayak", "8051154726", covers[103]);
        contactList.add(a);
        a = new Contact("Jitendra Kumar", "9470194837", covers[104]);
        contactList.add(a);
        a = new Contact("K.C. Janak", "3262235902", covers[105]);
        contactList.add(a);
        a = new Contact("k. Priya Ajit", "9471191850", covers[106]);
        contactList.add(a);
        a = new Contact("K.S. Thayagaraj", "8888887308", covers[107]);
        contactList.add(a);
        a = new Contact("Kabir Dasgupta", "3262235443", covers[108]);
        contactList.add(a);
        a = new Contact("Kailash Jha", "3262235436", covers[109]);
        contactList.add(a);
        a = new Contact("Kalyan Chatterjee", "9431126489", covers[110]);
        contactList.add(a);
        a = new Contact("Kalyan Kumar Singh", "9546385852", covers[111]);
        contactList.add(a);
        a = new Contact("Kashinath Pal", "9471191821", covers[112]);
        contactList.add(a);
        a = new Contact("Kaushal Kumar", "9471191739", covers[113]);
        contactList.add(a);
        a = new Contact("Kaushik Muzumdar", "9771420587", covers[114]);
        contactList.add(a);
        a = new Contact("Keka Ojha", "3262235484", covers[115]);
        contactList.add(a);
        a = new Contact(" Kironmala Chanda", "9430351290", covers[116]);
        contactList.add(a);
        a = new Contact("Kripamoy Sarkar", "9570145254", covers[117]);
        contactList.add(a);
        a = new Contact("Krishnendu Shaw", "3262235166", covers[118]);
        contactList.add(a);
        a = new Contact("L.A. Kumarswamidhas", "9471191647", covers[119]);
        contactList.add(a);
        a = new Contact("Lohitkumar Naingeli ", "9471192372", covers[120]);
        contactList.add(a);
        a = new Contact("M.Jawed", "9431122638", covers[121]);
        contactList.add(a);
        a = new Contact("Madan Lal Chandravanshi", "9471191089", covers[122]);
        contactList.add(a);
        a = new Contact("Mahendra Yadav", "9430101387", covers[123]);
        contactList.add(a);
        a = new Contact("Manish Kumar Jain", "9431711095", covers[124]);
        contactList.add(a);
        a = new Contact("Mo. Mojbhur Rahman", "3262235490", covers[125]);
        contactList.add(a);
        a = new Contact("Mo. Sayeb Alam", "9470372048", covers[126]);
        contactList.add(a);
        a = new Contact("Mihir Kr. Sinha", "6097998789(US)", covers[127]);
        contactList.add(a);
        a = new Contact("Mohammed Sikander Azam", "9471191569", covers[128]);
        contactList.add(a);
        a = new Contact("Mohd Irfan", "9471192466", covers[129]);
        contactList.add(a);
        a = new Contact("Mohit Agrawal", "8824172323", covers[130]);
        contactList.add(a);
        a = new Contact("Moirangthem Rakesh Singh", "8877168602", covers[131]);
        contactList.add(a);
        a = new Contact("Mrinal Kanti Mukherjee", "9431711148", covers[132]);
        contactList.add(a);
        a = new Contact("Mrinal Sen", "2362235657", covers[133]);
        contactList.add(a);
        a = new Contact("Mrinalini Pandey", "9430136446", covers[134]);
        contactList.add(a);
        a = new Contact("Mritunjay Kumar Singh", "9431125817", covers[135]);
        contactList.add(a);
        a = new Contact("Mukul Kumar Das", "9470194846", covers[136]);
        contactList.add(a);
        a = new Contact("N R Mandre", "3262235556", covers[137]);
        contactList.add(a);
        a = new Contact("N.K. Singh", "9431711359", covers[138]);
        contactList.add(a);
        a = new Contact("Neetish Kumar Maurya", "9771458839", covers[139]);
        contactList.add(a);
        a = new Contact("Nikkam Suresh", "3262235442", covers[140]);
        contactList.add(a);
        a = new Contact("Niladri Das", "9430136495", covers[141]);
        contactList.add(a);
        a = new Contact("Nirajan Kumar", "9471191827", covers[142]);
        contactList.add(a);
        a = new Contact("Nirban Manna", "7549022324", covers[143]);
        contactList.add(a);
        a = new Contact("Nirupama Mandal", "3262235124", covers[144]);
        contactList.add(a);
        a = new Contact("Nitai Pal", "9471154739", covers[145]);
        contactList.add(a);
        a = new Contact("P K Behera", "9835176018", covers[146]);
        contactList.add(a);
        a = new Contact("P R Mohanty", "3262207152", covers[147]);
        contactList.add(a);
        a = new Contact(" Padinaidu Paluri", "3262235933", covers[148]);
        contactList.add(a);
        a = new Contact("Pankaj Kumar Jain", "3262235094", covers[149]);
        contactList.add(a);
        a = new Contact("Pankaj Mishra", "3262235669", covers[150]);
        contactList.add(a);
        a = new Contact("Paresh Kumar Nayak", "9471192452", covers[151]);
        contactList.add(a);
        a = new Contact("Paresh Nath Singh Roy", "3262235469", covers[152]);
        contactList.add(a);
        a = new Contact("Partha Sarthi Paul", "9430384494", covers[153]);
        contactList.add(a);
        a = new Contact("Patitapaban Sahu", "8987419603", covers[154]);
        contactList.add(a);
        a = new Contact("Pawan Kumar Singh", "3262235135", covers[155]);
        contactList.add(a);
        a = new Contact("Pentyala Srinivasa Rao", "3262235480", covers[156]);
        contactList.add(a);
        a = new Contact("Phalguni Sen", "3262235238", covers[157]);
        contactList.add(a);
        a = new Contact("Prabin Kumar Sarkar", "3262233527", covers[158]);
        contactList.add(a);
        a = new Contact("Prabhodha Ranjan Sahoo", "7549200242", covers[159]);
        contactList.add(a);
        a = new Contact("Pradip Kumar Sadhu", "9431126076", covers[160]);
        contactList.add(a);
        a = new Contact("Pramod Kumar Kewat", "3262235921", covers[161]);
        contactList.add(a);
        a = new Contact("Pramod PAthak", "3262235435", covers[162]);
        contactList.add(a);
        a = new Contact("PRANAB dAS", "9471191892", covers[163]);
        contactList.add(a);
        a = new Contact("Prashant K. Jana", "3262235473", covers[164]);
        contactList.add(a);
        a = new Contact("Prashant Kr. Mahato", "3262235646", covers[165]);
        contactList.add(a);
        a = new Contact("Prasoon Kumar Singh", "9431711057", covers[166]);
        contactList.add(a);
        a = new Contact("Prasun Jana", "3262235054", covers[167]);
        contactList.add(a);
        a = new Contact("Prosanta Kumar Khan", "3262235465", covers[168]);
        contactList.add(a);
        a = new Contact("R. Anand", "7631704704", covers[169]);
        contactList.add(a);
        a = new Contact("R. R Das", "8895556016", covers[170]);
        contactList.add(a);
        a = new Contact("R. Venugopal", "9334003523", covers[171]);
        contactList.add(a);
        a = new Contact("Rabindra Nath Hota", "3262235122", covers[172]);
        contactList.add(a);
        a = new Contact("Radhakanta Koner", "3262235739", covers[173]);
        contactList.add(a);
        a = new Contact(" Raghvendra Kumar Chaudhary", "3262235127", covers[174]);
        contactList.add(a);
        a = new Contact("Rahul Bhattacharya", "7763811074", covers[175]);
        contactList.add(a);
        a = new Contact("Rajeev Kumar Ranjan", "9471191517", covers[176]);
        contactList.add(a);
        a = new Contact("Rajeev Updhyay", "9430351877", covers[177]);
        contactList.add(a);
        a = new Contact("Rajendra k. Dubey", "9431711058", covers[178]);
        contactList.add(a);
        a = new Contact(" Rajendra Pamula", "9471191419", covers[179]);
        contactList.add(a);
        a = new Contact("Rajib Sarkar", "9430351282", covers[180]);
        contactList.add(a);
        a = new Contact("Rajni SIngh", "3262235447", covers[181]);
        contactList.add(a);
        a = new Contact("Rakesh Kumar", "9471191668", covers[182]);
        contactList.add(a);
        a = new Contact("Ram Krishna Singh", "3262235223", covers[183]);
        contactList.add(a);
        a = new Contact("Ram Pravesh Bhagat", "9470987236", covers[184]);
        contactList.add(a);
        a = new Contact("Ramanbabu Kaligatla", "3262235183", covers[185]);
        contactList.add(a);
        a = new Contact("Randip K. Das", "3262235479", covers[186]);
        contactList.add(a);
        a = new Contact("Ranjit Kumar Upadhyay", "3262235482", covers[187]);
        contactList.add(a);
        a = new Contact("Rashmi Madhuri", "9471191640", covers[188]);
        contactList.add(a);
        a = new Contact("Ravi Kumar Gangwar", "9771457994", covers[189]);
        contactList.add(a);
        a = new Contact("Rima Chaterjee", "3262235493", covers[190]);
        contactList.add(a);
        a = new Contact("Rothith P. John", "3262235665", covers[191]);
        contactList.add(a);
        a = new Contact("S.K. Panda", "3262235091", covers[192]);
        contactList.add(a);
        a = new Contact("S. Bhattacharya", "3262235457", covers[193]);
        contactList.add(a);
        a = new Contact("S. Bhattacharya", "3262235440", covers[194]);
        contactList.add(a);
        a = new Contact("S. Chaudhari", "3262235279", covers[195]);
        contactList.add(a);
        a = new Contact("S.K. Paul", "3262235244", covers[196]);
        contactList.add(a);
        a = new Contact("S. Mohanty", "9431122457", covers[197]);
        contactList.add(a);
        a = new Contact("S. Mukhopadhyaya", "3262235422", covers[198]);
        contactList.add(a);
        a = new Contact("S. Narayan", "3262235197", covers[199]);
        contactList.add(a);
        a = new Contact("S.P. Tiwari", "9431711226", covers[200]);
        contactList.add(a);
        a = new Contact("S.S. Mohapatra", "9861443377", covers[201]);
        contactList.add(a);
        a = new Contact("Sachin Kumar Singh", "9102991041", covers[202]);
        contactList.add(a);
        a = new Contact("Sachin Tripathi", "9471191359", covers[203]);
        contactList.add(a);
        a = new Contact("Sahendra SIngh", "9471191375", covers[204]);
        contactList.add(a);
        a = new Contact("Sandeep Mondal", "9430352782", covers[205]);
        contactList.add(a);
        a = new Contact("Sanjeev Anand Sahu", "3262235917", covers[206]);
        contactList.add(a);
        a = new Contact("Sanjeev Kumar Raghuwanshi", "9471191354", covers[207]);
        contactList.add(a);
        a = new Contact("Sanjit Kumar Pal", "9471191852", covers[208]);
        contactList.add(a);
        a = new Contact("Sanjoy K. Ghoshal", "9431711283", covers[209]);
        contactList.add(a);
        a = new Contact("Sanjoy Mondal", "3262235405", covers[210]);
        contactList.add(a);
        a = new Contact("sanket NAyak", "3262235143", covers[211]);
        contactList.add(a);
        a = new Contact("Sanatanu Dwari", "9431538392", covers[212]);
        contactList.add(a);
        a = new Contact("Santimony Kundu", "9471191592", covers[213]);
        contactList.add(a);
        a = new Contact("Sarvanan Pichiah", "no. mb", covers[214]);
        contactList.add(a);
        a = new Contact("Sarita Kar", "9204556362", covers[215]);
        contactList.add(a);
        a = new Contact("Saumen MAti", "9471192208", covers[216]);
        contactList.add(a);
        a = new Contact("Saumya SIngh", "3262235497", covers[217]);
        contactList.add(a);
        a = new Contact("Sauabh Dutta Gupta", "3262235072", covers[218]);
        contactList.add(a);
        a = new Contact("Seekhar Chandra Dutta", "7894407830", covers[219]);
        contactList.add(a);
        a = new Contact("Shailendra Kumar Sharma", "9431121600", covers[220]);
        contactList.add(a);
        a = new Contact("Shailendra Narayan SIngh", "9471191153", covers[221]);
        contactList.add(a);
        a = new Contact("Shalini Gautam", "3262235650", covers[222]);
        contactList.add(a);
        a = new Contact("Shalivanthan", "3262235475", covers[223]);
        contactList.add(a);
        a = new Contact("Shatrughan Soren", "3262235652", covers[224]);
        contactList.add(a);
        a = new Contact("Seeja Jagadevan", "3262235162", covers[225]);
        contactList.add(a);
        a = new Contact("Shibyan Sarkar", "9471191818", covers[226]);
        contactList.add(a);
        a = new Contact("Shishir Gupta", "3262235464", covers[227]);
        contactList.add(a);
        a = new Contact("Sharvan Kumar", "9771421510", covers[228]);
        contactList.add(a);
        a = new Contact("Shushanta Sarangi", "3262235763", covers[229]);
        contactList.add(a);
        a = new Contact("Shweta R. Malwe", "9471192142", covers[230]);
        contactList.add(a);
        a = new Contact("Siddharta SenGupta", "3262235155", covers[231]);
        contactList.add(a);
        a = new Contact("Somanath Chattopadhyay", "9431122518", covers[232]);
        contactList.add(a);
        a = new Contact("Somnath Pan", "9431124647", covers[233]);
        contactList.add(a);
        a = new Contact("Somnath Yadav", "3262235880", covers[234]);
        contactList.add(a);
        a = new Contact("Soumitra Kumar Bhaumik", "3262235156", covers[235]);
        contactList.add(a);
        a = new Contact("Soumen Bag", "3262235168", covers[236]);
        contactList.add(a);
        a = new Contact("Soumitra Maity", "3262235185", covers[237]);
        contactList.add(a);
        a = new Contact("Sowmiya Chawla", "9990907710", covers[238]);
        contactList.add(a);
        a = new Contact("Sridhar Sahu", "3262235919", covers[239]);
        contactList.add(a);
        a = new Contact("Srinivas Pasupaleti", "9471192234	", covers[240]);
        contactList.add(a);
        a = new Contact("Shubhankar Sen", "3262235188", covers[241]);
        contactList.add(a);
        a = new Contact("Subhasis Chatterjee", "9431126486", covers[242]);
        contactList.add(a);
        a = new Contact("Subindu Kumar", "9471191160", covers[243]);
        contactList.add(a);
        a = new Contact("Subodh Kumar Maiti", "9471191278", covers[244]);
        contactList.add(a);
        a = new Contact("Subrata Kumar Ghosh", "9430187029", covers[245]);
        contactList.add(a);
        a = new Contact("Sukanta Chakraborty", "3262235194", covers[246]);
        contactList.add(a);
        a = new Contact("Sukanta Das", "3262235653", covers[247]);
        contactList.add(a);
        a = new Contact("Sukanta Dey", "9431503788", covers[248]);
        contactList.add(a);
        a = new Contact("Sukha Ranjan Samadder", "9471191823", covers[249]);
        contactList.add(a);
        a = new Contact("Sukha Ranjan Samadder", "9471191823", covers[250]);
        contactList.add(a);
        a = new Contact("Sukumar Laik", "3262200274", covers[251]);
        contactList.add(a);
        a = new Contact("Suman Dutta", "3262235065", covers[252]);
        contactList.add(a);
        a = new Contact("Sumanta Kumar Gupta", "7631042241", covers[253]);
        contactList.add(a);
        a = new Contact("Sunil Kumar Gupta", "3262235474", covers[254]);
        contactList.add(a);
        a = new Contact("Sunil Kumar Gupta", "9431126495", covers[255]);
        contactList.add(a);
        a = new Contact("Suresh Kumar Yatirajula", "3262235906", covers[256]);
        contactList.add(a);
        a = new Contact("Suresh Pandian E", "3262235753", covers[257]);
        contactList.add(a);
        a = new Contact("Sushila Vikas Maheshkar", "3262295797", covers[258]);
        contactList.add(a);
        a = new Contact("Sushrut Das", "9430374392", covers[259]);
        contactList.add(a);
        a = new Contact("Swapan Dey", "3262235607", covers[260]);
        contactList.add(a);
        a = new Contact("T.K. Chatterjee", "3262235437", covers[261]);
        contactList.add(a);
        a = new Contact("Tajdarul Hassan Syed", "3262235408", covers[262]);
        contactList.add(a);
        a = new Contact("Tanish Dey", "9471192447", covers[263]);
        contactList.add(a);
        a = new Contact("Tanmoy Maity", "9471191126", covers[264]);
        contactList.add(a);
        a = new Contact("Tanushree Kaibartta", "3262235273", covers[265]);
        contactList.add(a);
        a = new Contact("Tanweer Alam", "9471191849", covers[266]);
        contactList.add(a);
        a = new Contact("Tarkeshwar Kumar", "8051088444", covers[267]);
        contactList.add(a);
        a = new Contact("Tarun Kumar Naiya", "3262235879", covers[268]);
        contactList.add(a);
        a = new Contact("U.K. Singh", "3262235222", covers[269]);
        contactList.add(a);
        a = new Contact("Upama Dutta", "3262235070", covers[270]);
        contactList.add(a);
        a = new Contact("Upendra Kumar Singh", "9470194998", covers[271]);
        contactList.add(a);
        a = new Contact("V.K. Saxena", "9431124410", covers[272]);
        contactList.add(a);
        a = new Contact("V. Kumar ", "9431122030", covers[273]);
        contactList.add(a);
        a = new Contact("V. M. S. R. Murthy", "3262235445", covers[274]);
        contactList.add(a);
        a = new Contact("V.P. Sharma", "3262206232", covers[275]);
        contactList.add(a);
        a = new Contact("V.V. Govind Kumar", "9471192205", covers[276]);
        contactList.add(a);
        a = new Contact("Vijaya Bhaskar", "3262235911", covers[277]);
        contactList.add(a);
        a = new Contact("Vikas Mahto", "9431711023", covers[278]);
        contactList.add(a);
        a = new Contact("Vinay Kumar Rajak", "8051101110", covers[279]);
        contactList.add(a);
        a = new Contact("Vinayak Ranjan ", "9470383975", covers[280]);
        contactList.add(a);
        a = new Contact("Vineet Kumar", "3262235216", covers[281]);
        contactList.add(a);
        a = new Contact("Vineet Kumar Rai", "3262235282", covers[282]);
        contactList.add(a);
        a = new Contact("Vinod Kumar Saxena", "I", covers[283]);
        contactList.add(a);
        a = new Contact("Vipin Kumar", "9471191352", covers[284]);
        contactList.add(a);
        a = new Contact("Vishnu Priye", "9431125155", covers[285]);
        contactList.add(a);
        a = new Contact("Vivek Bajpai", "9430351330", covers[286]);
        contactList.add(a);
        a = new Contact("Vivekananda Mukherjee", "3262235644		", covers[287]);
        contactList.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Contact> newList = new ArrayList<>();
        for (Contact contact : contactList) {
            String name = contact.getName().toLowerCase();
            if (name.contains(newText))
                newList.add(contact);
        }
        adapter.setFilter(newList);
        return true;
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
}
