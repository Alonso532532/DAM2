void main(){
  print(saludar());
  print(sumar(2,4));
  print(sumarOpcional(2));
  print(saludoCompleto(nombre: "TheKrey", mensaje: "Hey: "));
}

// String saludar(){
//   return "Hola";
// }

String saludar() => "Hola";

//int sumar(int a, int b) {
//  return a+b;
//}

int sumar(int a, int b) => a+b;

// Si no le paso b el valor será de 0
int sumarOpcional(int a, [int b = 0]) => a+b;

String saludoCompleto({required String nombre, String mensaje = "Hola, "}){
  return '${mensaje} ${nombre}';
}
