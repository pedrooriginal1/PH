import java.util.Scanner;
public class calculadora{
    public static int menu(){
        int op;
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        do {
            System.out.println(" MENU ");
            System.out.println(" 1 - ADIÇÃO ");
            System.out.println(" 2 - SUBTRAÇÃO ");
            System.out.println(" 3 - MULTIPLICAÇÃO ");
            System.out.println(" 4 - DIVISÃO ");
            System.out.print(" OPÇÃO: ");
            op = input.nextInt();
            
            if (op < 1 || op > 4) {
                System.out.println("Opção inválida! Tente novamente.");
            }
    
        } while (op < 1 || op > 4);
    
        return op;
    
}

    public static float entradaDados(){
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.println(" ENTRADA DE DADOS ");
        System.out.println(" Número: ");
    float num = input.nextFloat();
    return num;
    }

    public static float adicao(float n1,  float n2){
        System.out.println(" ADIÇÃO ");
        return  n1 + n2;
    }

    public static float subtracao(float n1, float n2){
        System.out.println(" SUBTRAÇÃO ");
        return n1 - n2;
    }

    public static float multiplicacao(float  n1, float n2){
        System.out.println(" MULTIPLICAÇÃO ");
        return n1 * n2;
    } 

    public static float divisao(float n1,  float n2){
        System.out.println(" DIVISÃO ");
        return n1 / n2;
    } 

    public static void imprimir(float result){
        System.out.println(" IMPRIMIR ");
        System.out.println(" Resultado " + result);
    }

    public static float controlador(float n1, float n2, int op){
        System.out.println(" CONTROLADOR ");
        float resultado = 0;
        switch(op){
        case 1:
            resultado = adicao(n1, n2);
        break;
        case 2:
            resultado = subtracao(n1, n2);
        break;
        case 3:
            resultado = multiplicacao(n1, n2);
        break;
        case 4:
            resultado = divisao(n1, n2);
        break;
        }
        return resultado;
    }

    public static void main(String[] args){
        System.out.println(" MAIN ");
        int op = menu();
        float n1 = entradaDados();
        float n2 = entradaDados();
        float result = controlador(n1, n2, op);
        imprimir(result);
    }
}