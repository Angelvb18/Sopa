package bathleship;

import java.util.Random;
import java.util.Scanner;

public class Bathleship {
     //hola
    static Scanner lea = new Scanner(System.in);
    static Random r = new Random();

    public static void main(String[] args) {
        char[][] camp1 = new char[10][10];
        char[][] camp2 = new char[10][10];
        char[][] tab1 = new char[10][10];
        char[][] tab2 = new char[10][10];
        char resp = 's';
        while (resp == 's') {
            tab1 = c(tab1);
            tab2 = c(tab2);
            camp1 = c(camp1);
            camp2 = c(camp2);
            camp1 = genc(camp1, 0);
            camp2 = genc(camp2, 0);
            String cord;
            int win = 0, turn, op;
            char nav;
            camp1 = c(camp1);
            camp2 = c(camp2);
            camp1 = genc(camp1, 0);
            camp2 = genc(camp2, 0);
            System.out.println("1.Disparo\n2.Disparo multiple\nIngrese una opcion:");
            op = lea.nextInt();
            switch (op) {
                case 1://un Disparo
                    while (win != 17) {
                        turn = 1 + r.nextInt(2);
                        if (turn % 2 != 0) {
                            System.out.println("Turno del jugador 1");
                            imprimeMatriz(tab1, 0, 0);
                            System.out.println("Ingrese cordenada de la manera fila,columna");
                            cord = lea.next();
                            while (cord.length() < 3 || cord.indexOf(',') == -1 || cord.charAt(1) != ',' || cord.length() > 3) {
                                System.out.println("Ingrese cordenada de la manera fila,columna");
                                cord = lea.next();
                            }
                            String[] t = cord.split(",");
                            while (tab1[Integer.parseInt(t[0])][Integer.parseInt(t[1])] == 'x' || tab1[Integer.parseInt(t[0])][Integer.parseInt(t[1])] == 'O') {
                                System.out.println("Ingrese cordenada de la manera fila,columna");
                                cord = lea.next();
                                while (cord.length() < 3 || cord.indexOf(',') == -1 || cord.charAt(1) != ',' || cord.length() > 3) {
                                    System.out.println("Ingrese cordenada de la manera fila,columna");
                                    cord = lea.next();
                                }
                                t = cord.split(",");
                            }
                            if (camp2[Integer.parseInt(t[0])][Integer.parseInt(t[1])] == ' ') {
                                System.out.println("No hacerto");
                                tab1[Integer.parseInt(t[0])][Integer.parseInt(t[1])] = 'x';
                            } else {
                                System.out.println("Acierto golpeo a una nave");
                                tab1[Integer.parseInt(t[0])][Integer.parseInt(t[1])] = 'O';
                                nav = camp2[Integer.parseInt(t[0])][Integer.parseInt(t[1])];
                                camp2[Integer.parseInt(t[0])][Integer.parseInt(t[1])] = 'O';
                                if (navd(camp2, nav) == false) {
                                    System.out.println(navdes(nav));
                                }
                            }
                        } else {

                            System.out.println("Turno del jugador 2");
                            imprimeMatriz(tab2, 0, 0);
                            System.out.println("Ingrese cordenada de la manera fila,columna");
                            cord = lea.next();
                            while (cord.length() < 3 || cord.indexOf(',') == -1 || cord.charAt(1) != ',' || cord.length() > 3) {
                                System.out.println("Ingrese cordenada de la manera fila,columna");
                                cord = lea.next();
                            }
                            String[] t = cord.split(",");
                            while (tab2[Integer.parseInt(t[0])][Integer.parseInt(t[1])] == 'x' || tab2[Integer.parseInt(t[0])][Integer.parseInt(t[1])] == 'O') {
                                System.out.println("Ingrese cordenada de la manera fila,columna");
                                cord = lea.next();
                                while (cord.length() < 3 || cord.indexOf(',') == -1 || cord.charAt(1) != ',' || cord.length() > 3) {
                                    System.out.println("Ingrese cordenada de la manera fila,columna");
                                    cord = lea.next();
                                }
                                t = cord.split(",");
                            }

                            if (camp1[Integer.parseInt(t[0])][Integer.parseInt(t[1])] == ' ') {
                                System.out.println("No hacerto");
                                tab2[Integer.parseInt(t[0])][Integer.parseInt(t[1])] = 'x';
                            } else {
                                System.out.println("Acierto golpeo a una nave");
                                nav = camp1[Integer.parseInt(t[0])][Integer.parseInt(t[1])];
                                camp1[Integer.parseInt(t[0])][Integer.parseInt(t[1])] = 'O';
                                tab2[Integer.parseInt(t[0])][Integer.parseInt(t[1])] = 'O';
                                if (navd(camp1, nav) == false) {
                                    System.out.println(navdes(nav));
                                }
                            }
                        }

                        if (turn % 2 != 0) {
                            if (17 == win(tab1)) {
                                win = 17;
                                System.out.println("Gana jugador 1");
                            }
                        } else {
                            if (17 == win(tab2)) {
                                win = 17;
                                System.out.println("Gana jugador 2");
                            }
                        }
                    }
                    break;
                case 2://Dispar mutiple
                    turn = 1;
                    int dis;
                    while (win != 17) {
                        if (turn % 2 != 0) {
                            dis = contn(camp1);
                            for (int i = 0; i < dis; i++) {
                                System.out.println("Turno del jugador 1");
                                imprimeMatriz(tab1, 0, 0);
                                System.out.println("Ingrese cordenada de la manera fila,columna");
                                cord = lea.next();
                                while (cord.length() < 3 || cord.indexOf(',') == -1 || cord.charAt(1) != ',' || cord.length() > 3) {
                                    System.out.println("Ingrese cordenada de la manera fila,columna");
                                    cord = lea.next();
                                }
                                String[] t = cord.split(",");
                                while (tab1[Integer.parseInt(t[0])][Integer.parseInt(t[1])] == 'x' || tab1[Integer.parseInt(t[0])][Integer.parseInt(t[1])] == 'O') {
                                    System.out.println("Ingrese cordenada de la manera fila,columna");
                                    cord = lea.next();
                                    while (cord.length() < 3 || cord.indexOf(',') == -1 || cord.charAt(1) != ',' || cord.length() > 3) {
                                        System.out.println("Ingrese cordenada de la manera fila,columna");
                                        cord = lea.next();
                                    }
                                    t = cord.split(",");
                                }
                                if (camp2[Integer.parseInt(t[0])][Integer.parseInt(t[1])] == ' ') {
                                    System.out.println("No hacerto");
                                    tab1[Integer.parseInt(t[0])][Integer.parseInt(t[1])] = 'x';
                                } else {
                                    System.out.println("Acierto golpeo a una nave");
                                    tab1[Integer.parseInt(t[0])][Integer.parseInt(t[1])] = 'O';
                                    nav = camp2[Integer.parseInt(t[0])][Integer.parseInt(t[1])];
                                    camp2[Integer.parseInt(t[0])][Integer.parseInt(t[1])] = 'O';
                                    if (navd(camp2, nav) == false) {
                                        System.out.println(navdes(nav));
                                    }
                                }
                            }

                        } else {
                            System.out.println("Turno del jugador 2");
                            dis = contn(camp2);
                            for (int i = 0; i < dis; i++) {
                                imprimeMatriz(tab2, 0, 0);
                                System.out.println("Ingrese cordenada de la manera fila,columna");
                                cord = lea.next();
                                while (cord.length() < 3 || cord.indexOf(',') == -1 || cord.charAt(1) != ',' || cord.length() > 3) {
                                    System.out.println("Ingrese cordenada de la manera fila,columna");
                                    cord = lea.next();
                                }
                                String[] t = cord.split(",");
                                while (tab2[Integer.parseInt(t[0])][Integer.parseInt(t[1])] == 'x' || tab2[Integer.parseInt(t[0])][Integer.parseInt(t[1])] == 'O') {
                                    System.out.println("Ingrese cordenada de la manera fila,columna");
                                    cord = lea.next();
                                    while (cord.length() < 3 || cord.indexOf(',') == -1 || cord.charAt(1) != ',' || cord.length() > 3) {
                                        System.out.println("Ingrese cordenada de la manera fila,columna");
                                        cord = lea.next();
                                    }
                                    t = cord.split(",");
                                }
                                if (camp1[Integer.parseInt(t[0])][Integer.parseInt(t[1])] == ' ') {
                                    System.out.println("No hacerto");
                                    tab2[Integer.parseInt(t[0])][Integer.parseInt(t[1])] = 'x';
                                } else {
                                    System.out.println("Acierto golpeo a una nave");
                                    tab2[Integer.parseInt(t[0])][Integer.parseInt(t[1])] = 'O';
                                    nav = camp1[Integer.parseInt(t[0])][Integer.parseInt(t[1])];
                                    camp1[Integer.parseInt(t[0])][Integer.parseInt(t[1])] = 'O';
                                    if (navd(camp1, nav) == false) {
                                        System.out.println(navdes(nav));
                                    }
                                }
                                
                            }
                        }
                        if (turn % 2 != 0) {
                            if (17 == win(tab1)) {
                                win = 17;
                                System.out.println("Gana jugador 1");
                            }
                        } else {
                            if (17 == win(tab2)) {
                                win = 17;
                                System.out.println("Gana jugador 2");
                            }
                        }
                        turn++;
                    }
                    break;
                default:
                    System.out.println("Ingreso una opcion no valida");
                    break;
            }
            System.out.println("Desea volver al menu:[s/n]");
            resp = lea.next().charAt(0);
        }
    }

    public static char[][] genc(char[][] camp, int co) {
        if (co == 5) {
            put(camp, co);
            return camp;
        } else {
            return genc(put(camp, co), co + 1);
        }
    }

    public static char[][] put(char[][] camp, int co) {
        switch (co) {
            case 1://Porta aviones
                int f = 0 + r.nextInt(1),
                 c = 0 + r.nextInt(9);
                int dic = 2 - r.nextInt(2);
                if (dic == 1) {
                    f = 0 + r.nextInt(1);
                    if (f == 1) {

                        f = camp.length - 1;
                        camp[f][c] = '*';
                        camp[f - 1][c] = '*';
                        camp[f - 2][c] = '*';
                        camp[f - 3][c] = '*';
                        camp[f - 4][c] = '*';
                    } else {
                        f = 0;

                        camp[f][c] = '*';
                        camp[f + 1][c] = '*';
                        camp[f + 2][c] = '*';
                        camp[f + 3][c] = '*';

                        camp[f + 4][c] = '*';

                    }
                } else {

                    c = 0 + r.nextInt(1);
                    if (c == 1) {
                        c = 4;
                        camp[f][c] = '*';
                        camp[f][c + 1] = '*';
                        camp[f][c + 2] = '*';
                        camp[f][c + 3] = '*';
                        camp[f][c + 4] = '*';

                    } else {

                        c = 0;
                        camp[f][c] = '*';
                        camp[f][c + 1] = '*';
                        camp[f][c + 2] = '*';
                        camp[f][c + 3] = '*';
                        camp[f][c + 4] = '*';
                    }
                }

                break;
            case 2://Acorazado

                boolean ra = false;
                while (ra == false) {
                    f = 0 + r.nextInt(9);
                    c = 0 + r.nextInt(9);

                    dic = 2 - r.nextInt(2);

                    if (dic == 1) {

                        f = 0 + r.nextInt(3);
                        if (f == 1) {
                            f = camp.length - 1;
                            if (camp[f][c] == ' ' && camp[f - 1][c] == ' ' && camp[f - 2][c] == ' ' && camp[f - 3][c] == ' ') {
                                camp[f][c] = 'a';
                                camp[f - 1][c] = 'a';
                                camp[f - 2][c] = 'a';
                                camp[f - 3][c] = 'a';
                                ra = true;
                            }
                        } else {

                            if (f == 0) {
                                if (camp[f][c] == ' ' && camp[f + 1][c] == ' ' && camp[f + 2][c] == ' ' && camp[f + 3][c] == ' ') {

                                    camp[f][c] = 'a';
                                    camp[f + 1][c] = 'a';
                                    camp[f + 2][c] = 'a';
                                    camp[f + 3][c] = 'a';
                                    ra = true;
                                }

                            } else {
                                if (f == 2) {
                                    f = 1;
                                    if (camp[f][c] == ' ' && camp[f + 1][c] == ' ' && camp[f + 2][c] == ' ' && camp[f + 3][c] == ' ') {
                                        camp[f][c] = 'a';
                                        camp[f + 1][c] = 'a';
                                        camp[f + 2][c] = 'a';
                                        camp[f + 3][c] = 'a';
                                        ra = true;
                                    }

                                } else {
                                    if (f == 3) {

                                        f = camp.length - 2;
                                        if (camp[f][c] == ' ' && camp[f - 1][c] == ' ' && camp[f - 2][c] == ' ' && camp[f - 3][c] == ' ') {
                                            camp[f][c] = 'a';
                                            camp[f - 1][c] = 'a';
                                            camp[f - 2][c] = 'a';
                                            camp[f - 3][c] = 'a';
                                            ra = true;
                                        }

                                    }
                                }
                            }

                        }
                    } else {
                        c = 0 + r.nextInt(3);
                        if (c == 1) {
                            c = 4;
                            if (camp[f][c] == ' ' && camp[f][c + 1] == ' ' && camp[f][c + 2] == ' ' && camp[f][c + 3] == ' ') {
                                camp[f][c] = 'a';
                                camp[f][c + 1] = 'a';
                                camp[f][c + 2] = 'a';
                                camp[f][c + 3] = 'a';
                                ra = true;
                            }

                        } else {
                            if (c == 0) {
                                if (camp[f][c] == ' ' && camp[f][c + 1] == ' ' && camp[f][c + 2] == ' ' && camp[f][c + 3] == ' ') {
                                    camp[f][c] = 'a';
                                    camp[f][c + 1] = 'a';
                                    camp[f][c + 2] = 'a';
                                    camp[f][c + 3] = 'a';
                                    ra = true;
                                }

                            } else {
                                if (c == 3) {
                                    if (camp[f][c] == ' ' && camp[f][c + 1] == ' ' && camp[f][c + 2] == ' ' && camp[f][c + 3] == ' ') {
                                        camp[f][c] = 'a';
                                        camp[f][c + 1] = 'a';
                                        camp[f][c + 2] = 'a';
                                        camp[f][c + 3] = 'a';
                                        ra = true;
                                    }

                                } else {
                                    c = 1;
                                    if (camp[f][c] == ' ' && camp[f][c + 1] == ' ' && camp[f][c + 2] == ' ' && camp[f][c + 3] == ' ') {
                                        camp[f][c] = 'a';
                                        camp[f][c + 1] = 'a';
                                        camp[f][c + 2] = 'a';
                                        camp[f][c + 3] = 'a';
                                        ra = true;
                                    }

                                }

                            }
                        }

                    }
                }

                break;
            case 3://Destructor3
                ra = false;
                while (ra == false) {
                    f = 0 + r.nextInt(9);
                    c = 0 + r.nextInt(9);

                    dic = 2 - r.nextInt(2);

                    if (dic == 1) {

                        f = 0 + r.nextInt(3);
                        if (f == 1) {
                            f = camp.length - 1;
                            if (camp[f][c] == ' ' && camp[f - 1][c] == ' ' && camp[f - 2][c] == ' ') {
                                camp[f][c] = 'D';
                                camp[f - 1][c] = 'D';
                                camp[f - 2][c] = 'D';

                                ra = true;
                            }
                        } else {

                            if (f == 0) {
                                if (camp[f][c] == ' ' && camp[f + 1][c] == ' ' && camp[f + 2][c] == ' ') {

                                    camp[f][c] = 'D';
                                    camp[f + 1][c] = 'D';
                                    camp[f + 2][c] = 'D';

                                    ra = true;
                                }

                            } else {
                                if (f == 2) {
                                    f = 1;
                                    if (camp[f][c] == ' ' && camp[f + 1][c] == ' ' && camp[f + 2][c] == ' ') {
                                        camp[f][c] = 'D';
                                        camp[f + 1][c] = 'D';
                                        camp[f + 2][c] = 'D';

                                        ra = true;
                                    }

                                } else {
                                    if (f == 3) {

                                        f = camp.length - 2;
                                        if (camp[f][c] == ' ' && camp[f - 1][c] == ' ' && camp[f - 2][c] == ' ') {
                                            camp[f][c] = 'D';
                                            camp[f - 1][c] = 'D';
                                            camp[f - 2][c] = 'D';

                                            ra = true;
                                        }

                                    }
                                }
                            }

                        }
                    } else {
                        c = 0 + r.nextInt(3);
                        if (c == 1) {
                            c = 4;
                            if (camp[f][c] == ' ' && camp[f][c + 1] == ' ' && camp[f][c + 2] == ' ') {
                                camp[f][c] = 'D';
                                camp[f][c + 1] = 'D';
                                camp[f][c + 2] = 'D';

                                ra = true;
                            }

                        } else {
                            if (c == 0) {
                                if (camp[f][c] == ' ' && camp[f][c + 1] == ' ' && camp[f][c + 2] == ' ') {
                                    camp[f][c] = 'D';
                                    camp[f][c + 1] = 'D';
                                    camp[f][c + 2] = 'D';

                                    ra = true;
                                }

                            } else {
                                if (c == 3) {
                                    if (camp[f][c] == ' ' && camp[f][c + 1] == ' ' && camp[f][c + 2] == ' ') {
                                        camp[f][c] = 'D';
                                        camp[f][c + 1] = 'D';
                                        camp[f][c + 2] = 'D';

                                        ra = true;
                                    }

                                } else {
                                    c = 1;
                                    if (camp[f][c] == ' ' && camp[f][c + 1] == ' ' && camp[f][c + 2] == ' ') {
                                        camp[f][c] = 'D';
                                        camp[f][c + 1] = 'D';
                                        camp[f][c + 2] = 'D';

                                        ra = true;
                                    }

                                }

                            }
                        }

                    }
                }
                break;
            case 4://Submarino3
                ra = false;
                while (ra == false) {
                    f = 0 + r.nextInt(9);
                    c = 0 + r.nextInt(9);

                    dic = 2 - r.nextInt(2);

                    if (dic == 1) {

                        f = 0 + r.nextInt(3);
                        if (f == 1) {
                            f = camp.length - 1;
                            if (camp[f][c] == ' ' && camp[f - 1][c] == ' ' && camp[f - 2][c] == ' ') {
                                camp[f][c] = 'S';
                                camp[f - 1][c] = 'S';
                                camp[f - 2][c] = 'S';

                                ra = true;
                            }
                        } else {

                            if (f == 0) {
                                if (camp[f][c] == ' ' && camp[f + 1][c] == ' ' && camp[f + 2][c] == ' ') {

                                    camp[f][c] = 'S';
                                    camp[f + 1][c] = 'S';
                                    camp[f + 2][c] = 'S';

                                    ra = true;
                                }

                            } else {
                                if (f == 2) {
                                    f = 1;
                                    if (camp[f][c] == ' ' && camp[f + 1][c] == ' ' && camp[f + 2][c] == ' ') {
                                        camp[f][c] = 'S';
                                        camp[f + 1][c] = 'S';
                                        camp[f + 2][c] = 'S';

                                        ra = true;
                                    }

                                } else {
                                    if (f == 3) {

                                        f = camp.length - 2;
                                        if (camp[f][c] == ' ' && camp[f - 1][c] == ' ' && camp[f - 2][c] == ' ') {
                                            camp[f][c] = 'S';
                                            camp[f - 1][c] = 'S';
                                            camp[f - 2][c] = 'S';

                                            ra = true;
                                        }

                                    }
                                }
                            }

                        }
                    } else {
                        c = 0 + r.nextInt(3);
                        if (c == 1) {
                            c = 4;
                            if (camp[f][c] == ' ' && camp[f][c + 1] == ' ' && camp[f][c + 2] == ' ') {
                                camp[f][c] = 'S';
                                camp[f][c + 1] = 'S';
                                camp[f][c + 2] = 'S';

                                ra = true;
                            }

                        } else {
                            if (c == 0) {
                                if (camp[f][c] == ' ' && camp[f][c + 1] == ' ' && camp[f][c + 2] == ' ') {
                                    camp[f][c] = 'S';
                                    camp[f][c + 1] = 'S';
                                    camp[f][c + 2] = 'S';

                                    ra = true;
                                }

                            } else {
                                if (c == 3) {
                                    if (camp[f][c] == ' ' && camp[f][c + 1] == ' ' && camp[f][c + 2] == ' ') {
                                        camp[f][c] = 'S';
                                        camp[f][c + 1] = 'S';
                                        camp[f][c + 2] = 'S';

                                        ra = true;
                                    }

                                } else {
                                    c = 1;
                                    if (camp[f][c] == ' ' && camp[f][c + 1] == ' ' && camp[f][c + 2] == ' ') {
                                        camp[f][c] = 'S';
                                        camp[f][c + 1] = 'S';
                                        camp[f][c + 2] = 'S';

                                        ra = true;
                                    }

                                }

                            }
                        }

                    }
                }
                break;
            case 5://Patrullero
                ra = false;
                while (ra == false) {
                    f = 0 + r.nextInt(9);
                    c = 0 + r.nextInt(9);

                    dic = 2 - r.nextInt(2);

                    if (dic == 1) {

                        f = 0 + r.nextInt(3);
                        if (f == 1) {
                            f = camp.length - 1;
                            if (camp[f][c] == ' ' && camp[f - 1][c] == ' ') {
                                camp[f][c] = 'P';
                                camp[f - 1][c] = 'P';

                                ra = true;
                            }
                        } else {

                            if (f == 0) {
                                if (camp[f][c] == ' ' && camp[f + 1][c] == ' ') {

                                    camp[f][c] = 'P';
                                    camp[f + 1][c] = 'P';

                                    ra = true;
                                }

                            } else {
                                if (f == 2) {
                                    f = 1;
                                    if (camp[f][c] == ' ' && camp[f + 1][c] == ' ') {
                                        camp[f][c] = 'P';
                                        camp[f + 1][c] = 'P';

                                        ra = true;
                                    }

                                } else {
                                    if (f == 3) {

                                        f = camp.length - 2;
                                        if (camp[f][c] == ' ' && camp[f - 1][c] == ' ') {
                                            camp[f][c] = 'P';
                                            camp[f - 1][c] = 'P';

                                            ra = true;
                                        }

                                    }
                                }
                            }

                        }
                    } else {
                        c = 0 + r.nextInt(3);
                        if (c == 1) {
                            c = 4;
                            if (camp[f][c] == ' ' && camp[f][c + 1] == ' ') {
                                camp[f][c] = 'P';
                                camp[f][c + 1] = 'P';

                                ra = true;
                            }

                        } else {
                            if (c == 0) {
                                if (camp[f][c] == ' ' && camp[f][c + 1] == ' ') {
                                    camp[f][c] = 'P';
                                    camp[f][c + 1] = 'P';

                                    ra = true;
                                }

                            } else {
                                if (c == 3) {
                                    if (camp[f][c] == ' ' && camp[f][c + 1] == ' ') {
                                        camp[f][c] = 'P';
                                        camp[f][c + 1] = 'P';

                                        ra = true;
                                    }

                                } else {
                                    c = 1;
                                    if (camp[f][c] == ' ' && camp[f][c + 1] == ' ') {
                                        camp[f][c] = 'P';
                                        camp[f][c + 1] = 'P';

                                        ra = true;
                                    }

                                }

                            }
                        }

                    }
                }
                break;
        }
        return camp;
    }

    public static void imprimeMatriz(char matriz[][], int filas, int cols) {
        if (filas == matriz.length - 1 && cols == matriz[0].length - 1) {//caso base
            System.out.println("[" + matriz[filas][cols] + "]");
            System.out.println("   0  1  2  3  4  5  6  7  8  9");
        } else {
            if (cols == matriz[0].length - 1) {
                System.out.println("[" + matriz[filas][cols] + "]");
                imprimeMatriz(matriz, filas + 1, 0);
            } else {
                if (cols == 0) {
                    System.out.print(filas + " ");
                }
                System.out.print("[" + matriz[filas][cols] + "]");
                imprimeMatriz(matriz, filas, cols + 1);
            }
        }
    }

    public static int win(char[][] x) {
        int r = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (x[i][j] == 'O') {
                    r++;
                }
            }
        }
        return r;
    }

    public static boolean navd(char[][] x, char z) {
        int xa = 0;
        boolean r = false;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (z == x[i][j]) {
                    xa++;
                }
            }
        }
        if (xa != 0) {
            r = true;
        }

        return r;
    }

    public static char[][] c(char[][] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                c[i][j] = ' ';
            }
        }
        return c;
    }

    public static int contn(char[][] x) {
        String navd = "";
        int con = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                navd += x[i][j];
            }
        }
        if (navd.indexOf('*') != -1) {
            con++;
        }
        if (navd.indexOf('a') != -1) {
            con++;
        }
        if (navd.indexOf('P') != -1) {
            con++;
        }
        if (navd.indexOf('S') != -1) {
            con++;
        }
        if (navd.indexOf('D') != -1) {
            con++;
        }
        return con;
    }

    public static String navdes(char a) {
        String fa = "";
        switch (a) {
            case 'a':
                fa = "Se a destruido el Acorazado";
                break;
            case '*':
                fa = "Se a destruido el Porta aviones";
                break;
            case 'P':
                fa = "Se a destruido el Patrullero";
                break;
            case 'S':
                fa = "Se a destruido el Destructor";
                break;
            case 'D':
                fa = "Se a destruido el Destructor";
                break;

        }
        return fa;
    }
}
