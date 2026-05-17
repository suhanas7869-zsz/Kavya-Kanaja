// Home Screen Activity

public class HomeScreen extends AppCompatActivity {

    TextView poemTitle, meaningText, poetName;
    ImageView poetImage;

    Button btnMeaning, btnListen, btnAskAI;

    TextToSpeech textToSpeech;

    String poem =
            "ನಿಸರ್ಗವೇ ನಮ್ಮ ಜೀವ";

    String meaning =
            "Nature is the source of life and peace.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        poemTitle = findViewById(R.id.poemTitle);
        meaningText = findViewById(R.id.meaningText);
        poetName = findViewById(R.id.poetName);

        poetImage = findViewById(R.id.poetImage);

        btnMeaning = findViewById(R.id.btnMeaning);
        btnListen = findViewById(R.id.btnListen);
        btnAskAI = findViewById(R.id.btnAskAI);

        poemTitle.setText(poem);

        poetName.setText("Kuvempu");

        meaningText.setVisibility(View.INVISIBLE);

        // Read Meaning Button
        btnMeaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                meaningText.setVisibility(View.VISIBLE);

                meaningText.setText(meaning);
            }
        });

        // Text To Speech
        textToSpeech = new TextToSpeech(
                getApplicationContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {

                        textToSpeech.setLanguage(
                                new Locale("kn","IN"));
                    }
                });

        // Listen Poem Button
        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textToSpeech.speak(
                        poem,
                        TextToSpeech.QUEUE_FLUSH,
                        null,
                        null
                );
            }
        });

        // Ask AI Button
        btnAskAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(HomeScreen.this);

                builder.setTitle("Ask AI");

                builder.setMessage(
                        "This poem explains peaceful living and nature."
                );

                builder.setPositiveButton(
                        "OK",
                        null
                );

                builder.show();
            }
        });
    }
}