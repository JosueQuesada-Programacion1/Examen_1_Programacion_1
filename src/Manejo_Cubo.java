import javax.swing.*;

public class Manejo_Cubo {
    private int[][][] cubo;
    private String[] Vec_empleados;
    private int[] Vec_salarios;
    private int cant_empleados;
    public void Ini_Vec_Empleados() {
        cant_empleados = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de empleados"));
        if (cant_empleados <= 0) {
            System.out.println("Error, debe ingresar un valor igual o mayor a 1!");
            return;
        }
        Vec_empleados = new String[cant_empleados];
        for (int i = 0; i < Vec_empleados.length; i++) {
            Vec_empleados[i] = JOptionPane.showInputDialog("Digite el nombre del empleado");
        }
    }
    public void Ini_Vec_Salarios(){
        if (cant_empleados <= 0) {
            System.out.println("Error, debe ingresar un valor igual o mayor a 1!");
            return;
        }
        Vec_salarios = new int[cant_empleados];
        for (int i = 0; i < Vec_salarios.length; i++) {
            System.out.println("Empleado a asignar salario: "+Vec_empleados[i]);
            Vec_salarios[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite el monto por hora del empleado"));
            System.out.println("==================================================================================");
        }
    }
//    1. Deberá de ajustar el metodo de iniCubo para que cumpla con las siguientes restricciones:
//    a. Un empleado NO puede trabajar más de 12 horas diarias.
//    b. Hay meses que tienen 5 semanas y otros que solo tienen 4 semanas.
//    c. El metodo sigue registrando por medio de valores aleatorios.
    public void Ini_Cubo() {
//        if (cant_empleados <= 0) {
//            System.out.println("Error, debe ingresar un valor igual o mayor a 1!");
//            return;
//        }
        int opc = Integer.parseInt(JOptionPane.showInputDialog("Digite el mes \n 1. Enero \n 2. Febrero \n 3. Marzo \n 4. Abril \n 5. Mayo \n 6. Junio \n 7. Julio \n 8. Agosto \n 9. Septiembre \n 10. Octubre \n 11. Noviembre \n 12. Diciembre"));
        int cant_semanas=0;
        boolean aux = false;
        if(opc==2){
            aux=true;
        } else{
            aux=false;
        }
        if (aux==true){
            cant_semanas=5;
        }else{
            cant_semanas=4;
        }
        cubo = new int[cant_empleados][cant_semanas][6];
        for(int fil = 0; fil < cubo.length; fil++) {
            for(int col = 0; col < cubo[fil].length; col++) {
                for(int prof = 0; prof < cubo[fil][col].length; prof++) {
                    cubo[fil][col][prof] =(int)(Math.random() * (12 - 0 + 1)) + 0;
                }
            }
        }
    }
    //        for(Ingredientes ing : prd.getReceta().getIngredientes()){
    //            System.out.printf("%-8s %-8s %-15s\n",
//                    String.valueOf(ing.getCantidad()),
//                    String.valueOf(ing.getMedida()),
//                    ing.getNombre());
//
//
//        }
    //MODIFICAR A FORMATO============================================================
    public void Imp_Cubo() {
        if (cubo == null) {
            System.out.println("Error, el cubo no se ha inicializado");
            return;
        }
        for(int col = 0; col < cubo[0].length; col++) {
            System.out.println("=================================================");
            System.out.printf("%-12s %-12s \n", "DATOS", "SEMANA " + (col + 1));
            System.out.printf("%-12s %-2s %-2s %-2s %-2s %-2s %-2s  \n", "===========", "L", "K", "M", "J", "V", "S");
            for (int fil = 0; fil < cubo.length; fil++) {
                System.out.printf("%-13s", Vec_empleados[fil]);
                System.out.printf("%-3s %-3s %-3s %-3s %-3s \n", cubo[fil][col][0],
                        cubo[fil][col][1],
                        cubo[fil][col][2],
                        cubo[fil][col][3],
                        cubo[fil][col][4]);
            }
        }
    }
    public void Imp_Nomina(){
        if (Vec_salarios == null) {
            System.out.println("Error, el vector de salarios no se ha inicializado");
            return;
        }
        int[] aux = new int[cant_empleados];
            for (int i = 0; i< cubo.length; i++){
                for (int j = 0; j<cubo[i].length; j++){
                    aux[i] += cubo[i][j][0];
                    aux[i] += cubo[i][j][1];
                    aux[i] += cubo[i][j][2];
                    aux[i] += cubo[i][j][3];
                    aux[i] += cubo[i][j][4];
                    aux[i] += cubo[i][j][5];
                }
            }

        System.out.printf("%-11s %-27s %-24s %-11s", "DATOS","HORAS NORMALES","HORAS EXTRA","SALARIO BRUTO");
        System.out.printf("%-11s %-9s %-9s %-9s %-8s %-8s %-8s %-11s", " ", "CANTIDAD", "VALOR", "MONTO", "CANTIDAD", "VALOR", "MONTO");
        for (int i = 0; i<Vec_empleados; i++){
            System.out.printf("%-11s %-9s %-9s %-9s %-8s %-8s %-8s %-11s", Vec_empleados[i], aux[i], Vec_salarios[i], (aux[i]*Vec_salarios), aux[i], (Vec_salarios[i]*1.5),  (aux[i]*(Vec_salarios[i]*1.5));
        }
    }
    public static void main(String[] args) {
        Manejo_Cubo x = new Manejo_Cubo();
        x.Ini_Vec_Empleados();
        x.Ini_Cubo();
        x.Imp_Cubo();
    }
}
