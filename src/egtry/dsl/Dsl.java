/* Generated By:JavaCC: Do not edit this line. Dsl.java */
package egtry.dsl;
import java.io.StringReader;
import java.util.Scanner;


public class Dsl implements DslConstants {

        private static String tagType = "";
        private static String src = "";
        private static String fontFamily = "";
        private static String content = "";
        private static String colorStr = "";
        private static String href = "";
        private static int occurrencesOfAnd = 0;
        public static boolean status = false;


    public static void main(String[] args) throws Exception {


            Scanner scanner = new Scanner(System.in);
            String string = scanner.nextLine();
                String[] words = string.split(" ");
                String word = "AND";
                for (int i=0; i<words.length; i++) {
                if (words[i].equals(word))
                        occurrencesOfAnd++;
            }
                Dsl dsl = new Dsl(new StringReader(string));
                try {
                  dsl.parse();
                } catch(Exception e) {
                     status = true;
                }

            HtmlTagsFactory htmlTagsFactory = new HtmlTagsFactory(dsl.tagType, dsl.src, dsl.fontFamily,
             dsl.content, dsl.colorStr, dsl.href);
            System.out.println(htmlTagsFactory.createTag());
    }

  static final public void parse() throws ParseException {
  Token t = null;
  String s = "";
    jj_consume_token(ADD);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IMAGE:
      img();
    tagType = "img";
      break;
    case PARAGRAPH:
      paragraph();
    tagType = "p";
      break;
    case HEADING:
      header();
         tagType = "h1";
      break;
    case LINK:
      url();
          tagType = "a";
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public String sentence() throws ParseException {
  Token t = null;
  String s = "";
    jj_consume_token(QUOTE);
    label_1:
    while (true) {
      t = jj_consume_token(ALPHANUMERIC);
     s += t.image;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ALPHANUMERIC:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
    }
    jj_consume_token(QUOTE);
   {if (true) return s;}
    throw new Error("Missing return statement in function");
  }

  static final public void text() throws ParseException {
  String s = "";
    jj_consume_token(TEXT);
    s = sentence();
   content = s;
  }

  static final public void color() throws ParseException {
  String s = "";
    jj_consume_token(COLOR);
    s = sentence();
   colorStr = s;
  }

  static final public void font() throws ParseException {
  String s = "";
    jj_consume_token(FONT);
    s = sentence();
   fontFamily = s;
  }

  static final public void link() throws ParseException {
  String s = "";
    jj_consume_token(LINK);
    s = sentence();
   href = s;
  }

  static final public void option() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TEXT:
      text();
      break;
    case COLOR:
      color();
      break;
    case FONT:
      font();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public Token decorated_text_extension() throws ParseException {
  Token t = null;
    jj_consume_token(AND);
    jj_consume_token(WITH);
    option();
    {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public void decorated_text() throws ParseException {
  int count = 0;
    jj_consume_token(WITH);
    option();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      decorated_text_extension();
                        count++;
                        if (count == occurrencesOfAnd)
                                {if (true) return;}
    }
  }

  static final public void url_option() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LINK:
      link();
      break;
    case TEXT:
      text();
      break;
    case COLOR:
      color();
      break;
    case FONT:
      font();
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public Token decorated_url_extension() throws ParseException {
        Token t = null;
    jj_consume_token(AND);
    jj_consume_token(WITH);
    url_option();
   {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public void decorated_url() throws ParseException {
   int count = 0;
    jj_consume_token(WITH);
    url_option();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
      decorated_url_extension();
                        count++;
                        if (count == occurrencesOfAnd)
                        {if (true) return;}
    }
  }

  static final public void img() throws ParseException {
  String s = "";
    jj_consume_token(IMAGE);
    jj_consume_token(WITH);
    jj_consume_token(SOURCE);
    s = sentence();
           src = s;
  }

  static final public void header() throws ParseException {
    jj_consume_token(HEADING);
    decorated_text();
  }

  static final public void paragraph() throws ParseException {
    jj_consume_token(PARAGRAPH);
    decorated_text();
  }

  static final public void url() throws ParseException {
    jj_consume_token(LINK);
    decorated_url();
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public DslTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[6];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x3900,0x20,0x38000,0x4000,0x3a000,0x4000,};
   }

  /** Constructor with InputStream. */
  public Dsl(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Dsl(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new DslTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Dsl(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new DslTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Dsl(DslTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(DslTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[18];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 6; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 18; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}