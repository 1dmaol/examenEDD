import java.awt.BorderLayout;
/**
* Classe Calculadora.java examen
* @author Marc Oller Caballé
* @version 1.0
*/
public class Calculadora {
 
// Constants
final int MAX_DIGITS = 5;
final int MODE_ENTRADA = 0;
final int MODE_RESULTAT = 1;
 
//Variables
int mode;
int valor1;
int valor2;
String operacio;
boolean inicialitza_resultat;
 
private static Text text_resultat;
/**
* Constructor
*/ 
public Calculadora(boolean gui) {
 
//InicialitzaciÃ³ de les variables.
inicialitza();
 
if (gui==true) dibuixaCalculadora();
 
}
 
private void dibuixaCalculadora() {
 
Display display = Display.getDefault();
Shell shlCalculadora = new Shell();
shlCalculadora.setSize(259, 250);
shlCalculadora.setText("Calculadora");
 
//-------------------------------------------------
//NÃºmeros
//-------------------------------------------------
 
//butÃ² amb el nÃºmero 0
Button button_0 = new Button(shlCalculadora, SWT.NONE);
button_0.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
afageixNouDigit(0);
}
});
button_0.setText("0");
button_0.setBounds(23, 163, 40, 33);
 
//butÃ² amb el nÃºmero 1
Button button_1 = new Button(shlCalculadora, SWT.NONE);
button_1.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
afageixNouDigit(1);
}
});
button_1.setText("1");
button_1.setBounds(23, 124, 40, 33);
 
//butÃ² amb el nÃºmero 2
Button button_2 = new Button(shlCalculadora, SWT.NONE);
button_2.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
afageixNouDigit(2);
}
});
button_2.setText("2");
button_2.setBounds(69, 124, 40, 33);
 
//butÃ² amb el nÃºmero 3
Button button_3 = new Button(shlCalculadora, SWT.NONE);
button_3.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
afageixNouDigit(3);
}
});
button_3.setText("3");
button_3.setBounds(115, 124, 40, 33);
 
//butÃ² amb el nÃºmero 4
Button button_4 = new Button(shlCalculadora, SWT.NONE);
button_4.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
afageixNouDigit(4);
}
});
button_4.setText("4");
button_4.setBounds(23, 85, 40, 33);
 
//butÃ² amb el nÃºmero 5
Button button_5 = new Button(shlCalculadora, SWT.NONE);
button_5.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
afageixNouDigit(5);
}
});
button_5.setText("5");
button_5.setBounds(69, 85, 40, 33);
 
//butÃ² amb el nÃºmero 6
Button button_6 = new Button(shlCalculadora, SWT.NONE);
button_6.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
afageixNouDigit(6);
}
});
button_6.setText("6");
button_6.setBounds(115, 85, 40, 33);
 
//butÃ² amb el nÃºmero 7
Button button_7 = new Button(shlCalculadora, SWT.NONE);
button_7.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
afageixNouDigit(7);
}
});
button_7.setText("7");
button_7.setBounds(23, 46, 40, 33);
 
//butÃ² amb el nÃºmero 8
Button button_8 = new Button(shlCalculadora, SWT.NONE);
button_8.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
afageixNouDigit(8);
}
});
button_8.setBounds(69, 46, 40, 33);
button_8.setText("8");
 
//butÃ² amb el nÃºmero 9
Button button_9 = new Button(shlCalculadora, SWT.NONE);
button_9.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
afageixNouDigit(9);
}
});
button_9.setText("9");
button_9.setBounds(115, 46, 40, 33);
 
//-------------------------------------------------
//Operacions
//-------------------------------------------------
 
//butÃ² amb l'operaciÃ³ de divisiÃ³
Button button_12 = new Button(shlCalculadora, SWT.NONE);
button_12.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
executarOperador("/");
}
});
button_12.setText("/");
button_12.setBounds(178, 46, 40, 33);
 
//butÃ² amb l'operaciÃ³ de multiplicaciÃ³
Button button_13 = new Button(shlCalculadora, SWT.NONE);
button_13.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
executarOperador("*");
}
});
button_13.setText("*");
button_13.setBounds(178, 85, 40, 33);
 
//butÃ² amb l'operaciÃ³ de suma
Button button_14 = new Button(shlCalculadora, SWT.NONE);
button_14.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
executarOperador("+");
}
});
button_14.setText("+");
button_14.setBounds(178, 124, 40, 33);
 
//butÃ² amb l'operaciÃ³ de resta
Button button_15 = new Button(shlCalculadora, SWT.NONE);
button_15.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
executarOperador("-");
}
});
button_15.setText("-");
button_15.setBounds(178, 163, 40, 33);
 
//butÃ² amb l'operaciÃ³ de igual
Button button_11 = new Button(shlCalculadora, SWT.NONE);
button_11.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
executarIgual();
}
});
button_11.setText("=");
button_11.setBounds(69, 163, 86, 33);
 
//Text on es visualitza el resultat
text_resultat = new Text(shlCalculadora, SWT.BORDER);
text_resultat.setText("0");
text_resultat.setBounds(22, 19, 196, 21);
 
shlCalculadora.open();
shlCalculadora.layout();
while (!shlCalculadora.isDisposed()) {
if (!display.readAndDispatch()) {
display.sleep();
}
}
}
/**
* Inicialització de les variables de la calculadora.
*/
public void inicialitza() {
operacio = "null";
valor1 = 0;
valor2 = 0;
mode = MODE_ENTRADA;
inicialitza_resultat = true;
}
/**
* Retorna el valor del camp text_resultat com un valor text
* @return cadena del resultat
*/
public String getResultatString (){
return text_resultat.getText();
}
/**
* Assigna un valor al camp text_resultat
* @param s cadena de text assignada a text_resultat
*/
public void setResultatString(String s){
text_resultat.setText(s);
}
/**
* Retorna el valor del camp text_resultat com un valor numèric.
* @return valor numèric del resultat
*/
public int getResultatInt() {
String resultat = text_resultat.getText();
return Integer.parseInt(resultat);
}
/**
* Afegeix un nou dígit al camp text_resultat.
* @param digit numero enter per a afegir.
*/
public void afageixNouDigit(int digit){
if (inicialitza_resultat)
setResultatString("");
 
String inputString = getResultatString();
 
if (inputString.indexOf("0") == 0){
inputString = inputString.substring(1);
}
 
if ((!inputString.equals("0") || digit > 0) && inputString.length() < MAX_DIGITS){
setResultatString(inputString + digit);
}
 
mode = MODE_ENTRADA;
inicialitza_resultat = false;
}
/**
* Únicament en el cas de poder executar l'operació, s'han assignat els dos operands és quan el sistema realitza la crida d'execució.
* @param new_operacio transporta la cadena una operació
*/
public void executarOperador(String new_operacio) {
 
int resultat;
 
if (operacio.equals("null"))
{
resultat = getResultatInt();
valor1 = resultat;
}
 
else
{
valor2 = getResultatInt();
resultat = executarOperacio();
mostraResultat(resultat);
valor1 = resultat;
}
 
inicialitza_resultat = true;
operacio = new_operacio;
}
/**
* Al finalitzar el càlcul s'executa la darrera operació especificada i es visualitza el resultat.
*/
public void executarIgual(){
int resultat = 0;
 
valor2 = getResultatInt();
resultat = executarOperacio();
mostraResultat(resultat);
 
operacio = "null";
}
/**
* Execució de la operació que pot ser una suma, resta, divisió o multiplicació.
* @return resultat de la operació
*/
public int executarOperacio() {
int resultat = 0;
 
if (operacio.equals("/"))
{
 
if (valor2 == 0)
{
JOptionPane.showMessageDialog(null, "No es pot dividir per cero", "Error", JOptionPane.ERROR_MESSAGE);
operacio = "null";
valor1 = 0;
mode = MODE_ENTRADA;
inicialitza_resultat = true;
}
else
resultat = valor1 / valor2;
}
 
if (operacio.equals("*"))
resultat = valor1 * valor2;
 
if (operacio.equals("-"))
resultat = valor1 - valor2;
 
if (operacio.equals("+"))
resultat = valor1 + valor2;
 
return resultat;
}
/**
* Mostra el resultat de les operacions realitzades.
* @param resultat resultat de la operació
*/
public void mostraResultat(int resultat){
setResultatString(Integer.toString(resultat));
valor1 = resultat;
mode = MODE_RESULTAT;
inicialitza_resultat = true;
}
/**
* Inici en l'execució de la calculadora.
* @param args[] vector de cadenes de text parametritzats que s'invoquen junt a l'execució del programa
*/
public static void main(String args[]) {
Calculadora calculadora = new Calculadora(true);
}
 
}
