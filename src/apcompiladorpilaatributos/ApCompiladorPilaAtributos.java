// la gramática que va a reconocer es la siguiente

// 1.<S>      --> <E> {Resultado}             Selección(1)={(,I} 
// 2.<E>      --> +<E><E>{suma}               Selección(2)={(,I}
// 3.<E>    -->   *<E><E>{mult}               Selección(3)={+}
// 4.<E>    -->   I                           Selección (4)= I

package apcompiladorpilaatributos;

public class ApCompiladorPilaAtributos {

    static Lexico lexico = new Lexico();

    // static String cad="((((5+3)))+5+3+2)-1¬";
    static String cad1 = "0123456789.";

    static String cad = "+5*4 3¬";
    static int indice = 0;
    static char sim = ' ';
    static Lexico lex1 = new Lexico();
    static String cadavance = "";
    static Analizador analizador = new Analizador();

    public static void main(String[] args) {

        analisisLexico();
        cad = lex1.cadenaLexico();
        sim = lex1.darElemento(indice).darTipo();
        cadavance = cadavance + sim;
        // crea los nodos para determinar el fondo de pila con v y el axioma
        // o no terminal inicial s

        NoTerminal v = new NoTerminal("v", 0, 0);
        NoTerminal s = new NoTerminal("S", 0, 0);
        // adiciona a la pila el fondo v y el axiona s. (en la clase analizador se
        // tiene un arrayList para controlar la pila

        analizador.adicionarNodo(v);
        analizador.adicionarNodo(s);
        // analizador.mostrarCadenaPila();
        NoTerminal nt = null;

        // Realiza un ciclo do-while para controlar la cadena y realiza dos switches
        // para
        // controlar la tabla de control, el primero para evaluar la entrada y el
        // segundo para evaluar los símbolos de pila

        do {
            switch (sim) {
            // los símbolos de entrada son i,+,*
            case 'i':
                // en nt se almacena el nodo ultimo de la pila
                nt = analizador.getnode(analizador.ultimo());
                // los símbolos de pila son s,e,el,t,tl,p,pl,f,)
                switch (nt.getNombre()) {
                case "S":
                    proceso1();
                    analizador.mostrarCadenaPila();
                    break;
                case "ELO":
                    proceso2();
                    analizador.mostrarCadenaPila();
                    break;
                case "EL2":
                    proceso5();
                    analizador.mostrarCadenaPila();
                    break;
                case "ER":
                    proceso8();
                    analizador.mostrarCadenaPila();
                    break;
                case "E":
                    proceso21();
                    analizador.mostrarCadenaPila();
                    break;
                case "ME":
                    proceso13();
                    analizador.mostrarCadenaPila();
                    break;
                case "MA":
                    proceso16();
                    analizador.mostrarCadenaPila();
                    break;
                case "T":
                    proceso25();
                    analizador.mostrarCadenaPila();
                    break;
                case "P":
                    proceso29();
                    analizador.mostrarCadenaPila();
                    break;
                case "F":
                    proceso33();
                    analizador.mostrarCadenaPila();
                    break;
                // case "suma":
                // break;
                // case "resta":
                // break;
                // case "mul":
                // break;
                // case "div":
                // break;
                // case "exp":
                // break;
                // case "procOr":
                // break;
                // case "procAnd":
                // break;
                // case "pRelacion":
                // break;
                // case "pComparar":
                // break;
                // case "res":
                // break;
                default:
                    rechace();
                }
                break;
            case '+':
                nt = analizador.getnode(analizador.ultimo());
                switch (nt.getNombre()) {
                case "EL":
                    proceso22();
                    analizador.mostrarCadenaPila();
                    break;
                case "TL":
                    proceso28();
                    analizador.mostrarCadenaPila();
                    break;
                case "PL":
                    proceso31();
                    analizador.mostrarCadenaPila();
                    break;
                default:
                    rechace();
                }
                break;
            case '-':
                nt = analizador.getnode(analizador.ultimo());
                switch (nt.getNombre()) {
                case "EL":
                    proceso23();
                    analizador.mostrarCadenaPila();
                    break;
                case "TL":
                    proceso28();
                    analizador.mostrarCadenaPila();
                    break;
                case "PL":
                    proceso31();
                    analizador.mostrarCadenaPila();
                    break;
                default:
                    rechace();
                }
                break;
            case '*':
                nt = analizador.getnode(analizador.ultimo());
                switch (nt.getNombre()) {
                case "TL":
                    proceso26();
                    analizador.mostrarCadenaPila();
                    break;
                case "PL":
                    proceso31();
                    analizador.mostrarCadenaPila();
                    break;
                default:
                    rechace();

                }
                break;
            case '/':
                nt = analizador.getnode(analizador.ultimo());
                switch (nt.getNombre()) {
                case "TL":
                    proceso27();
                    analizador.mostrarCadenaPila();
                    break;
                case "PL":
                    proceso31();
                    analizador.mostrarCadenaPila();
                    break;
                default:
                    rechace();
                }
                break;
            case '^':
                nt = analizador.getnode(analizador.ultimo());
                switch (nt.getNombre()) {
                case "PL":
                    proceso30();
                    analizador.mostrarCadenaPila();
                    break;
                default:
                    rechace();

                }
                break;
            case '<':
                nt = analizador.getnode(analizador.ultimo());
                switch (nt.getNombre()) {
                case "ERL":
                    proceso9();
                    analizador.mostrarCadenaPila();
                    break;
                case "OR":
                    proceso11();
                    analizador.mostrarCadenaPila();
                    break;
                case "EL":
                    proceso24();
                    analizador.mostrarCadenaPila();
                    break;
                case "TL":
                    proceso28();
                    analizador.mostrarCadenaPila();
                    break;
                case "PL":
                    proceso31();
                    analizador.mostrarCadenaPila();
                    break;
                default:
                    rechace();
                }
                break;
            case '>':
                nt = analizador.getnode(analizador.ultimo());
                switch (nt.getNombre()) {
                case "ERL":
                    proceso9();
                    analizador.mostrarCadenaPila();
                    break;
                case "OR":
                    proceso14();
                    analizador.mostrarCadenaPila();
                    break;
                case "EL":
                    proceso24();
                    analizador.mostrarCadenaPila();
                    break;
                case "TL":
                    proceso28();
                    analizador.mostrarCadenaPila();
                    break;
                case "PL":
                    proceso31();
                    analizador.mostrarCadenaPila();
                    break;
                default:
                    rechace();
                }
                break;
            case '=':
                nt = analizador.getnode(analizador.ultimo());
                switch (nt.getNombre()) {
                case "ERL":
                    proceso9();
                    analizador.mostrarCadenaPila();
                    break;
                case "OR":
                    proceso17();
                    analizador.mostrarCadenaPila();
                    break;
                case "ME":
                    proceso12();
                    analizador.mostrarCadenaPila();
                    break;
                case "MA":
                    proceso15();
                    analizador.mostrarCadenaPila();
                    break;
                case "IG":
                    proceso18();
                    analizador.mostrarCadenaPila();
                    break;
                case "DI":
                    proceso20();
                    analizador.mostrarCadenaPila();
                    break;
                case "EL":
                    proceso24();
                    analizador.mostrarCadenaPila();
                    break;
                case "TL":
                    proceso28();
                    analizador.mostrarCadenaPila();
                    break;
                case "PL":
                    proceso31();
                    analizador.mostrarCadenaPila();
                    break;
                default:
                    rechace();
                }
                break;
            case '!':
                nt = analizador.getnode(analizador.ultimo());
                switch (nt.getNombre()) {
                case "ERL":
                    proceso9();
                    analizador.mostrarCadenaPila();
                    break;
                case "OR":
                    proceso19();
                    analizador.mostrarCadenaPila();
                    break;
                case "EL":
                    proceso24();
                    analizador.mostrarCadenaPila();
                    break;
                case "TL":
                    proceso28();
                    analizador.mostrarCadenaPila();
                    break;
                case "PL":
                    proceso31();
                    analizador.mostrarCadenaPila();
                    break;
                default:
                    rechace();
                }
                break;
            case '|':
                nt = analizador.getnode(analizador.ultimo());
                switch (nt.getNombre()) {

                case "ELOL":
                    proceso3();
                    analizador.mostrarCadenaPila();
                    break;
                case "EL2L":
                    proceso7();
                    analizador.mostrarCadenaPila();
                    break;
                case "ERL":
                    proceso10();
                    analizador.mostrarCadenaPila();
                    break;
                case "EL":
                    proceso24();
                    analizador.mostrarCadenaPila();
                    break;
                case "TL":
                    proceso28();
                    analizador.mostrarCadenaPila();
                    break;
                case "PL":
                    proceso31();
                    analizador.mostrarCadenaPila();
                    break;
                default:
                    rechace();
                }
                break;
            case '&':
                nt = analizador.getnode(analizador.ultimo());
                switch (nt.getNombre()) {
                case "EL2L":
                    proceso6();
                    analizador.mostrarCadenaPila();
                    break;
                case "ERL":
                    proceso10();
                    analizador.mostrarCadenaPila();
                    break;
                case "EL":
                    proceso24();
                    analizador.mostrarCadenaPila();
                    break;
                case "TL":
                    proceso28();
                    analizador.mostrarCadenaPila();
                    break;
                case "PL":
                    proceso31();
                    analizador.mostrarCadenaPila();
                    break;
                default:
                    rechace();
                }
                break;
            case '(':
                nt = analizador.getnode(analizador.ultimo());
                switch (nt.getNombre()) {

                case "S":
                    proceso1();
                    analizador.mostrarCadenaPila();
                    break;
                case "ELO":
                    proceso2();
                    analizador.mostrarCadenaPila();
                    break;
                case "EL2":
                    proceso5();
                    analizador.mostrarCadenaPila();
                    break;
                case "ER":
                    proceso8();
                    analizador.mostrarCadenaPila();
                    break;
                case "E":
                    proceso21();
                    analizador.mostrarCadenaPila();
                    break;
                case "ME":
                    proceso13();
                    analizador.mostrarCadenaPila();
                    break;
                case "MA":
                    proceso16();
                    analizador.mostrarCadenaPila();
                    break;
                case "T":
                    proceso25();
                    analizador.mostrarCadenaPila();
                    break;
                case "P":
                    proceso29();
                    analizador.mostrarCadenaPila();
                    break;
                case "F":
                    proceso32();
                    analizador.mostrarCadenaPila();
                    break;
                default:
                    rechace();

                }
                break;
            case ')':
                nt = analizador.getnode(analizador.ultimo());
                switch (nt.getNombre()) {

                case "ELOL":
                    proceso4();
                    analizador.mostrarCadenaPila();
                    break;
                case "EL2L":
                    proceso7();
                    analizador.mostrarCadenaPila();
                    break;
                case "ERL":
                    proceso10();
                    analizador.mostrarCadenaPila();
                    break;
                case "EL":
                    proceso24();
                    analizador.mostrarCadenaPila();
                    break;
                case "TL":
                    proceso28();
                    analizador.mostrarCadenaPila();
                    break;
                case "PL":
                    proceso31();
                    analizador.mostrarCadenaPila();
                    break;

                default:
                    rechace();

                }
                break;

            case '¬':
                nt = analizador.getnode(analizador.ultimo());
                switch (nt.getNombre()) {

                case "ELOL":
                    proceso4();
                    analizador.mostrarCadenaPila();
                    break;
                case "EL2L":
                    proceso7();
                    analizador.mostrarCadenaPila();
                    break;
                case "ERL":
                    proceso10();
                    analizador.mostrarCadenaPila();
                    break;
                case "EL":
                    proceso24();
                    analizador.mostrarCadenaPila();
                    break;
                case "TL":
                    proceso28();
                    analizador.mostrarCadenaPila();
                    break;
                case "PL":
                    proceso31();
                    analizador.mostrarCadenaPila();
                    break;

                default:
                    rechace();
                }
                break;
            default:
                rechace();
            }
            nt = analizador.getnode(analizador.ultimo());
        } while (!nt.getNombre().equalsIgnoreCase("v"));

        if (nt.getNombre().equalsIgnoreCase("v")) {
            System.out.println("Se acepta la secuencia ");
        } else
            System.out.println("Se rechaza la secuencia ");

    }

    public static void proceso1() { // OKAY

        int u = analizador.ultimo();
        NoTerminal i1 = new NoTerminal("i1", 0, 0);
        NoTerminal res = new NoTerminal("resultado", 0, 0);
        NoTerminal s1 = new NoTerminal("s1", u, 0);
        NoTerminal ELO = new NoTerminal("ELO", 0, 0);

        analizador.adicionarNodo(i1); // Push(i1
        analizador.adicionarNodo(res); // Push(res)
        analizador.adicionarNodo(s1); // Push(s1)
        analizador.adicionarNodo(ELO); // Push(E)
    }

    public static void proceso2() { // ! OKAY

        int u = analizador.ultimo();
        NoTerminal s1 = analizador.getnode(u - 1);
        NoTerminal s3 = new NoTerminal("s3", s1.getDirec(), 0);
        NoTerminal i1 = new NoTerminal("i1", 0, 0);
        NoTerminal ELOL = new NoTerminal("ELOL", 0, 0);
        NoTerminal s2 = new NoTerminal("s2", u, 0);
        NoTerminal EL2 = new NoTerminal("EL2", 0, 0);

        analizador.removeNodo(u);
        analizador.adicionarNodo(s3); // Push(i1
        analizador.adicionarNodo(i1); // Push(i1
        analizador.adicionarNodo(ELOL); // Push(i1
        analizador.adicionarNodo(s2); // Push(i1
        analizador.adicionarNodo(EL2); // Push(i1
    }

    public static void proceso3() { // TODO
        NoTerminal nt;

        int u = analizador.ultimo();

        NoTerminal s5 = new NoTerminal("s5", u - 2, 0);
        NoTerminal i6 = new NoTerminal("i6", 0, 0);
        NoTerminal ELOL = new NoTerminal("ELOL", 0, 0);
        NoTerminal s4 = new NoTerminal("s4", u + 1, 0);
        NoTerminal i5 = new NoTerminal("i5", 0, 0);
        NoTerminal i4 = new NoTerminal("i4", 0, 0);
        NoTerminal procOr = new NoTerminal("procOr", 0, 0);
        NoTerminal i3 = new NoTerminal("i3", u - 2, 0); // TODO s3
        NoTerminal i2 = new NoTerminal("i2", 0, 0);
        NoTerminal pRelacional = new NoTerminal("pRelacional", 0, 0);
        NoTerminal s2 = new NoTerminal("s2", u - 1, 0);
        NoTerminal EL2 = new NoTerminal("EL2", 0, 0);
        NoTerminal or = new NoTerminal("or", 0, 0); // TODO como se pone

        /*
         * 3. <ELO_L> i1,s1 -> | <EL2> s2{pRelacional} i2,i3 {procOR} i4,i5,s4 <ELO_L>
         * i6,s5 s1<-s3 i1<-s2 (En cual s2 i2?) (i2,i4)<-i1 (i3,i5)<-s2 (En cual s2 i2?)
         * i6<-s4 s1<-s5
         */

        analizador.removeNodo(u);
        analizador.adicionarNodo(s5);
        analizador.adicionarNodo(i6);
        analizador.adicionarNodo(ELOL);
        analizador.adicionarNodo(s4);
        analizador.adicionarNodo(i5);
        analizador.adicionarNodo(i4);
        analizador.adicionarNodo(procOr);
        analizador.adicionarNodo(i3);
        analizador.adicionarNodo(i2);
        analizador.adicionarNodo(pRelacional);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(EL2);
        analizador.adicionarNodo(or);

        avance();
    }

    public static void proceso4() {
        NoTerminal nt;
        int u = analizador.ultimo();
        nt = analizador.getnode(u - 1);
        nt.setDirec(u - 2);
        analizador.removeNodo(u);

    }

    public static void proceso5() {
        int u = analizador.ultimo();
        NoTerminal s1 = analizador.getnode(u - 1);
        NoTerminal s3 = new NoTerminal("s3", s1.getDirec(), 0);
        NoTerminal i1 = new NoTerminal("i1", 0, 0);
        NoTerminal EL2L = new NoTerminal("EL2L", 0, 0);
        NoTerminal s2 = new NoTerminal("s2", u + 1, 0);
        NoTerminal ER = new NoTerminal("ER", 0, 0);
        analizador.removeNodo(u);
        analizador.adicionarNodo(s3);
        analizador.adicionarNodo(i1);
        analizador.adicionarNodo(EL2L);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(ER);
    }

    public static void proceso6() {

        int u = analizador.ultimo();
        NoTerminal s5 = new NoTerminal("s5", u - 1, 0);
        NoTerminal i6 = new NoTerminal("i6", 0, 0);
        NoTerminal EL2L = new NoTerminal("EL2L", 0, 0);
        NoTerminal s4 = new NoTerminal("s4", u + 1, 0);
        NoTerminal i5 = new NoTerminal("i5", 0, 0);
        NoTerminal i4 = new NoTerminal("i4", 0, 0);
        NoTerminal procAnd = new NoTerminal("procAnd", 0, 0);
        NoTerminal i3 = new NoTerminal("i3", 0, 0);
        NoTerminal i2 = new NoTerminal("i2", 0, 0);
        NoTerminal pRelacional = new NoTerminal("pRelacional", 0, 0);
        NoTerminal s2 = new NoTerminal("s2", 0, 0);
        NoTerminal ER = new NoTerminal("ER", 0, 0);
        // NoTerminal and = new NoTerminal("ER", 0, 0); // TODO se pone?
        analizador.removeNodo(u);
        analizador.adicionarNodo(s5);
        analizador.adicionarNodo(i6);
        analizador.adicionarNodo(EL2L);
        analizador.adicionarNodo(s4);
        analizador.adicionarNodo(i5);
        analizador.adicionarNodo(i4);
        analizador.adicionarNodo(procAnd);
        analizador.adicionarNodo(i3);
        analizador.adicionarNodo(i2);
        analizador.adicionarNodo(pRelacional);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(ER);
        // analizador.adicionarNodo(and); // TODO se pone?

        avance();
    }

    public static void proceso7() {
        NoTerminal nt;
        int u = analizador.ultimo();
        nt = analizador.getnode(u - 1);
        nt.setDirec(u - 2);
        analizador.removeNodo(u);
    }

    public static void proceso8() { // OKAY
        int u = analizador.ultimo();
        NoTerminal s1 = analizador.getnode(u - 1);
        NoTerminal s3 = new NoTerminal("s3", s1.getDirec(), 0);
        NoTerminal i1 = new NoTerminal("i1", 0, 0);
        NoTerminal ERL = new NoTerminal("ERL", 0, 0);
        NoTerminal s2 = new NoTerminal("s2", u + 1, 0);
        NoTerminal E = new NoTerminal("E", 0, 0);
        analizador.removeNodo(u);
        analizador.adicionarNodo(s3);
        analizador.adicionarNodo(i1);
        analizador.adicionarNodo(ERL);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(E);
    }

    public static void proceso9() {
        NoTerminal i1;
        int u = analizador.ultimo();
        // i1 = analizador.getnode(u - 1);
        // i1.setDirec(u + 3);
        NoTerminal s4 = new NoTerminal("s4", u - 2, 0);
        NoTerminal i4 = new NoTerminal("i4", 0, 0);
        NoTerminal i3 = new NoTerminal("i3", 0, 0);
        NoTerminal i2 = new NoTerminal("i2", u + 1, 0);
        NoTerminal pComparar = new NoTerminal("pComparar", 0, 0);
        NoTerminal s3 = new NoTerminal("s3", u + 2, 0);
        NoTerminal E = new NoTerminal("E", 0, 0);
        NoTerminal s2 = new NoTerminal("s2", u, 0);

        analizador.removeNodo(u);
        analizador.adicionarNodo(s4);
        analizador.adicionarNodo(i4);
        analizador.adicionarNodo(i3);
        analizador.adicionarNodo(i2);
        analizador.adicionarNodo(pComparar);
        analizador.adicionarNodo(s3);
        analizador.adicionarNodo(E);
        analizador.adicionarNodo(s2);

    }

    public static void proceso10() { // TODO
        NoTerminal nt;
        int u = analizador.ultimo();
        nt = analizador.getnode(u - 1);
        nt.setDirec(u - 2);
        analizador.removeNodo(u);
    }

    public static void proceso11() { // OKAY
        int u = analizador.ultimo();
        NoTerminal s1 = analizador.getnode(u - 1);
        NoTerminal s2 = new NoTerminal("s2", s1.getDirec(), 0);
        NoTerminal ME = new NoTerminal("ME", 0, 0);
        analizador.removeNodo(u);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(ME);
        avance();
    }

    public static void proceso12() { // TODO
        int u = analizador.ultimo();
        avance();
    }

    public static void proceso13() { // TODO

        int u = analizador.ultimo();
        analizador.removeNodo(u);

    }

    public static void proceso14() { // OKAY
        int u = analizador.ultimo();
        NoTerminal s1 = analizador.getnode(u - 1);
        NoTerminal s2 = new NoTerminal("s2", s1.getDirec(), 0);
        NoTerminal MA = new NoTerminal("MA", 0, 0);
        analizador.removeNodo(u);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(MA);
        avance();
    }

    public static void proceso15() { // TODO
        int u = analizador.ultimo();

        analizador.removeNodo(u);
        avance();
    }

    public static void proceso16() { // TODO
        int u = analizador.ultimo();
        analizador.removeNodo(u);
    }

    public static void proceso17() { // OKAY
        int u = analizador.ultimo();
        NoTerminal s1 = analizador.getnode(u - 1);
        NoTerminal s2 = new NoTerminal("s2", s1.getDirec(), 0);
        NoTerminal IG = new NoTerminal("IG", 0, 0);
        analizador.removeNodo(u);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(IG);
        avance();
    }

    public static void proceso18() { // TODO
        int u = analizador.ultimo();
        analizador.removeNodo(u);
        avance();
    }

    public static void proceso19() { // ! Listo ?
        int u = analizador.ultimo();
        NoTerminal s1 = analizador.getnode(u - 1);
        NoTerminal s2 = new NoTerminal("s2", s1.getDirec(), 0);
        NoTerminal DI = new NoTerminal("DI", 0, 0);
        analizador.removeNodo(u);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(DI);
    }

    public static void proceso20() { // TODO
        int u = analizador.ultimo();
        analizador.removeNodo(u);
        avance();
    }

    public static void proceso21() { // ! Listo ?
        int u = analizador.ultimo();
        NoTerminal s1 = analizador.getnode(u - 1);
        NoTerminal s3 = new NoTerminal("s3", s1.getDirec(), 0);
        NoTerminal i1 = new NoTerminal("i1", 0, 0);
        NoTerminal EL = new NoTerminal("EL", 0, 0);
        NoTerminal s2 = new NoTerminal("s2", u + 1, 0);
        NoTerminal T = new NoTerminal("T", 0, 0);
        analizador.removeNodo(u);
        analizador.adicionarNodo(s3);
        analizador.adicionarNodo(i1);
        analizador.adicionarNodo(EL);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(T);
    }

    public static void proceso22() {
        int u = analizador.ultimo();
        NoTerminal s4 = new NoTerminal("s4", u - 2, 0);
        NoTerminal i4 = new NoTerminal("i4", u - 2, 0);
        NoTerminal EL = new NoTerminal("EL", u - 2, 0);
        NoTerminal s3 = new NoTerminal("s3", u - 2, 0);
        NoTerminal i3 = new NoTerminal("i3", u - 2, 0);
        NoTerminal i2 = new NoTerminal("i2", u - 2, 0);
        NoTerminal suma = new NoTerminal("suma", u - 2, 0);
        NoTerminal s2 = new NoTerminal("s2", u - 2, 0);
        NoTerminal T = new NoTerminal("T", u - 2, 0);
        analizador.removeNodo(u);
        analizador.adicionarNodo(s4);
        analizador.adicionarNodo(i4);
        analizador.adicionarNodo(EL);
        analizador.adicionarNodo(s3);
        analizador.adicionarNodo(i3);
        analizador.adicionarNodo(i2);
        analizador.adicionarNodo(suma);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(T);
        avance();
    }

    public static void proceso23() {
        int u = analizador.ultimo();
        NoTerminal s4 = new NoTerminal("s4", u - 2, 0);
        NoTerminal i4 = new NoTerminal("i4", u - 2, 0);
        NoTerminal EL = new NoTerminal("EL", u - 2, 0);
        NoTerminal s3 = new NoTerminal("s3", u - 2, 0);
        NoTerminal i3 = new NoTerminal("i3", u - 2, 0);
        NoTerminal i2 = new NoTerminal("i2", u - 2, 0);
        NoTerminal resta = new NoTerminal("resta", u - 2, 0);
        NoTerminal s2 = new NoTerminal("s2", u - 2, 0);
        NoTerminal T = new NoTerminal("T", u - 2, 0);
        analizador.removeNodo(u);
        analizador.adicionarNodo(s4);
        analizador.adicionarNodo(i4);
        analizador.adicionarNodo(EL);
        analizador.adicionarNodo(s3);
        analizador.adicionarNodo(i3);
        analizador.adicionarNodo(i2);
        analizador.adicionarNodo(resta);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(T);
        avance();
    }

    public static void proceso24() { // TODO
        int u = analizador.ultimo();
        analizador.removeNodo(u);
    }

    public static void proceso25() { // ! Listo ?

        int u = analizador.ultimo();
        NoTerminal s1 = analizador.getnode(u - 1);
        NoTerminal s3 = new NoTerminal("s3", s1.getDirec(), 0);
        NoTerminal i1 = new NoTerminal("i1", 0, 0);
        NoTerminal TL = new NoTerminal("TL", 0, 0);
        NoTerminal s2 = new NoTerminal("s2", u + 1, 0);
        NoTerminal F = new NoTerminal("F", 0, 0);
        analizador.removeNodo(u);
        analizador.adicionarNodo(s3);
        analizador.adicionarNodo(i1);
        analizador.adicionarNodo(TL);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(F);
    }

    public static void proceso26() {
        int u = analizador.ultimo();
        NoTerminal s4 = new NoTerminal("s4", u - 2, 0);
        NoTerminal i4 = new NoTerminal("i4", u - 2, 0);
        NoTerminal TL = new NoTerminal("TL", u - 2, 0);
        NoTerminal s3 = new NoTerminal("s3", u - 2, 0);
        NoTerminal i3 = new NoTerminal("i3", u - 2, 0);
        NoTerminal i2 = new NoTerminal("i2", u - 2, 0);
        NoTerminal mul = new NoTerminal("mul", u - 2, 0);
        NoTerminal s2 = new NoTerminal("s2", u - 2, 0);
        NoTerminal F = new NoTerminal("F", u - 2, 0);
        analizador.removeNodo(u);
        analizador.adicionarNodo(s4);
        analizador.adicionarNodo(i4);
        analizador.adicionarNodo(TL);
        analizador.adicionarNodo(s3);
        analizador.adicionarNodo(i3);
        analizador.adicionarNodo(i2);
        analizador.adicionarNodo(mul);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(F);
        avance();
    }

    public static void proceso27() {
        int u = analizador.ultimo();
        NoTerminal s4 = new NoTerminal("s4", u - 2, 0);
        NoTerminal i4 = new NoTerminal("i4", u - 2, 0);
        NoTerminal TL = new NoTerminal("TL", u - 2, 0);
        NoTerminal s3 = new NoTerminal("s3", u - 2, 0);
        NoTerminal i3 = new NoTerminal("i3", u - 2, 0);
        NoTerminal i2 = new NoTerminal("i2", u - 2, 0);
        NoTerminal div = new NoTerminal("div", u - 2, 0);
        NoTerminal s2 = new NoTerminal("s2", u - 2, 0);
        NoTerminal F = new NoTerminal("F", u - 2, 0);
        analizador.removeNodo(u);
        analizador.adicionarNodo(s4);
        analizador.adicionarNodo(i4);
        analizador.adicionarNodo(TL);
        analizador.adicionarNodo(s3);
        analizador.adicionarNodo(i3);
        analizador.adicionarNodo(i2);
        analizador.adicionarNodo(div);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(F);
        avance();

    }

    public static void proceso28() { // TODO
        int u = analizador.ultimo();
        analizador.removeNodo(u);
    }

    public static void proceso29() { // ! listo ?

        int u = analizador.ultimo();
        NoTerminal s1 = analizador.getnode(u - 1);
        NoTerminal s3 = new NoTerminal("s3", s1.getDirec(), 0);
        NoTerminal i1 = new NoTerminal("i1", u, 0);
        NoTerminal FL = new NoTerminal("FL", u, 0);
        NoTerminal s2 = new NoTerminal("s2", u + 1, 0);
        NoTerminal P = new NoTerminal("P", u, 0);
        analizador.removeNodo(u);
        analizador.adicionarNodo(s3);
        analizador.adicionarNodo(i1);
        analizador.adicionarNodo(FL);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(P);
    }

    public static void proceso30() {
        int u = analizador.ultimo();
        NoTerminal s4 = new NoTerminal("s4", u - 2, 0);
        NoTerminal i4 = new NoTerminal("i4", u - 2, 0);
        NoTerminal FL = new NoTerminal("FL", u - 2, 0);
        NoTerminal s3 = new NoTerminal("s3", u - 2, 0);
        NoTerminal i3 = new NoTerminal("i3", u - 2, 0);
        NoTerminal i2 = new NoTerminal("i2", u - 2, 0);
        NoTerminal exp = new NoTerminal("exp", u - 2, 0);
        NoTerminal s2 = new NoTerminal("s2", u - 2, 0);
        NoTerminal P = new NoTerminal("P", u - 2, 0);
        analizador.removeNodo(u);
        analizador.adicionarNodo(s4);
        analizador.adicionarNodo(i4);
        analizador.adicionarNodo(FL);
        analizador.adicionarNodo(s3);
        analizador.adicionarNodo(i3);
        analizador.adicionarNodo(i2);
        analizador.adicionarNodo(exp);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(P);
        avance();
    }

    public static void proceso31() { // TODO
        int u = analizador.ultimo();
        analizador.removeNodo(u);
    }

    public static void proceso32() {
        int u = analizador.ultimo();
        NoTerminal s2 = new NoTerminal("s2", u - 2, 0);
        NoTerminal ELO = new NoTerminal("ELO", u - 2, 0);
        analizador.removeNodo(u);
        analizador.adicionarNodo(s2);
        analizador.adicionarNodo(ELO);
        avance();
    }

    public static void proceso33() { // ! lista?
        Elemento ele;
        NoTerminal nt, nt1;
        int u = analizador.ultimo();
        ele = lex1.darElemento(indice);
        nt = analizador.getnode(u - 1);
        nt1 = analizador.getnode(nt.getDirec());
        nt1.setValor(ele.darValor());
        analizador.removeNodo(u);
        analizador.removeNodo(u - 1);
        avance();
    }

    public static void suma() {
        // NoTerminal nt1, nt2, nt3, nt4;
        // int u = analizador.ultimo();
        // nt1 = analizador.getnode(u - 1);
        // nt2 = analizador.getnode(u - 2);
        // double sum = nt1.getValor() + nt2.getValor();
        // nt3 = analizador.getnode(u - 3);
        // nt4 = analizador.getnode(nt3.getDirec());
        // nt4.setValor(sum);
        // // desapilar suma y sus atributos
        // analizador.removeNodo(u);
        // analizador.removeNodo(u - 1);
        // analizador.removeNodo(u - 2);
        // analizador.removeNodo(u - 3);

    }

    public static void resta() {

    }

    public static void mult() {
        NoTerminal nt1, nt2, nt3, nt4;
        int u = analizador.ultimo();
        nt1 = analizador.getnode(u - 1);
        nt2 = analizador.getnode(u - 2);
        double mul = nt1.getValor() * nt2.getValor();
        nt3 = analizador.getnode(u - 3);
        nt4 = analizador.getnode(nt3.getDirec());
        nt4.setValor(mul);
        // desapilar suma y sus atributos
        analizador.removeNodo(u);
        analizador.removeNodo(u - 1);
        analizador.removeNodo(u - 2);
        analizador.removeNodo(u - 3);

    }

    public static void div() {
        NoTerminal nt1, nt2, nt3, nt4;
        int u = analizador.ultimo();
        nt1 = analizador.getnode(u - 1);
        nt2 = analizador.getnode(u - 2);
        double mul = nt1.getValor() * nt2.getValor();
        nt3 = analizador.getnode(u - 3);
        nt4 = analizador.getnode(nt3.getDirec());
        nt4.setValor(mul);
        // desapilar suma y sus atributos
        analizador.removeNodo(u);
        analizador.removeNodo(u - 1);
        analizador.removeNodo(u - 2);
        analizador.removeNodo(u - 3);

    }

    public static void exp() {

    }

    public static void procOr() {

    }

    public static void pRelacion() {

    }

    public void procAnd() {

    }

    public void pComparar() {
    }

    public static void resultado() {
        NoTerminal nt;
        int u = analizador.ultimo();
        nt = analizador.getnode(u - 1);
        System.out.println("Resultado =" + nt.getValor());
        analizador.removeNodo(u);
        analizador.removeNodo(u - 1);
    }

    public static void analisisLexico() {
        // Este analizador es sencillo determina solo constantes enteras y reales
        // positivas
        // Trabaja los diferentes elementos en un ArrayList que trabaja con la clase
        // Clexico
        // la cual define el ArrayList con la clase CElemento
        // Almacen los valores para poder hallar los resultados

        Elemento ele1;

        int i = 0;
        int ind = 0;
        char tip = 0;
        char sim1 = cad.charAt(i);
        double val = 0;

        while (sim1 != '¬') {
            // determina si sim1 esta en la cadena de digitos cad1 que es global
            if (cad1.indexOf(sim1) != -1) {
                String num = "";
                while (cad1.indexOf(sim1) != -1) {
                    num = num + sim1;
                    i++;
                    sim1 = cad.charAt(i);

                }
                // en el String num se almacena el entero y se lo almacena en val como doble
                // DeterminarNumero(num);
                if (determinarNumero(num)) {
                    val = Double.parseDouble(num);
                    tip = 'i';

                    // se tipifica el valor como i
                } else {
                    System.out.println("Se rechaza la secuencia");
                    System.exit(0);
                }

            } else {
                // si el simbolo de entrada no esta en cad1 lo tipifica como tal ej
                // +,-,* (,) etc.

                tip = (char) sim1;
                i++;
                sim1 = cad.charAt(i);
                val = 0;

            }

            // con los elementos establecidos anteriormente se crea el elemento y se lo
            // adicina a lex1 que es el objeto de la clase Clexico
            if (tip != ' ') {
                ele1 = new Elemento(tip, val, ind);
                lex1.adicionarElemento(ele1);

                ind = ind + 1;
            }
            // System.out.print("indice ="+ind);

        }
        ele1 = new Elemento('¬', 0, ind);
        lex1.adicionarElemento(ele1);
        lex1.mostrarLexico();
        System.out.println(" cadena" + lex1.cadenaLexico());
    }

    public static boolean determinarNumero(String numero) {
        // Este método recibe un número en string y determina mediante un autómata
        // finito
        // si está o no correcto. El string es una cadena de dígitos y el punto.
        // Retorna un valor booleano.

        int estado = 1, i = 0;
        char simbolo;
        boolean b = true;
        while (i < numero.length() && b) {
            simbolo = numero.charAt(i);
            switch (simbolo) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                switch (estado) {
                case 1:
                    estado = 2;
                    i++;

                    break;
                case 2:
                    estado = 2;
                    i++;

                    break;
                case 3:
                    estado = 4;
                    i++;

                    break;
                case 4:
                    estado = 4;
                    i++;

                    break;

                }
                break;
            case '.':
                switch (estado) {
                case 1:
                case 3:
                case 4:
                    b = false;
                    break;
                case 2:
                    estado = 3;
                    i++;

                    break;

                }
                break;
            default:
                b = false;
            }

        }
        return b;
    }

    public static void resultado(double res) {
        System.out.println("Resultado " + res);
    }

    public static void avance() {
        indice++;
        if (indice < cad.length()) {
            sim = lex1.darElemento(indice).darTipo();
            cadavance = cadavance + sim;
            System.out.println("Cadena procesada " + cadavance);

        }
    }

    public static void mostrarContador(int i2) {
        System.out.println("Cantidad de unos " + i2);
    }

    public static void rechace() {
        System.out.println("Se rechaza la secuencia");
        System.exit(0);
    }
}