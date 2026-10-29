import 'package:flutter/material.dart';

class ButtonsScreen extends StatelessWidget {
   
  const ButtonsScreen({super.key});
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Botones"),
      ),
      body: _Buttons(),
      floatingActionButton: FloatingActionButton(
        onPressed: (){},
        child: Icon(Icons.arrow_back_ios),),
    );
  }
}
// Al solo usarlo en este archivo se usa _
class _Buttons extends StatelessWidget {
  const new({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      // double.infinity especifica que ocupe lo que pueda ocupar
      width: double.infinity,
      // El singleChildScrollView sirve para poder "scrollear"
      child: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          //padding: EdgeInsetsGeometry.symmetric(horizontal: 20, vertical: 15),
          child: Column(
             children: [
              // Elevated buttons
              ElevatedButton(onPressed: (){}, child: Text("Elevated Button")),
              ElevatedButton(onPressed: null, child: Text("Elevated Button Disabled")),
              ElevatedButton.icon(
                onPressed: (){}, 
              label: Text("Elevated Icon Button"),
              icon: Icon(Icons.account_balance_wallet_outlined),),
              // Filled Buttons
        
              FilledButton(
                onPressed: (){}, 
                child: Text("Filled"),),
        
              FilledButton.icon(
                onPressed: (){}, 
                label: Text("Filled icon button"), 
                icon: Icon(Icons.ac_unit_sharp),
                // Posiciono el boton a la derecha
                iconAlignment: .end,),
              
              // Outlined Button
              OutlinedButton(onPressed: (){}, child: Text("Outlined")),
              OutlinedButton.icon(onPressed: (){}, label: Text("Outlined Icon"), icon: Icon(Icons.add_business_sharp),),
        
              //Text button
              TextButton(onPressed: (){}, child: Text("Text Button")),
              TextButton.icon(onPressed: (){}, label: Text("Text Button"), icon: Icon(Icons.local_drink),),
        
              //Icon button
              IconButton(onPressed: (){}, icon: Icon(Icons.screen_share_sharp)),
              // Para poner un elemento "WidgetStateProperty"
              IconButton(onPressed: (){}, icon: Icon(Icons.fit_screen_sharp, size: 40, color: Colors.white,), style: ButtonStyle(backgroundColor: WidgetStatePropertyAll(Colors.amber)),),
              // Para añadir un espacio
              SizedBox(height: 10,),
              // Para añadir un botón personalizado
              _customButton(),
              SizedBox(height: 10,),
              _customButton(),
              SizedBox(height: 10,),
              _customButton(),
              SizedBox(height: 10,),
              _customButton(),
              SizedBox(height: 10,),
              _customButton(),
              SizedBox(height: 10,),
              _customButton(),
             ],
          ),
        ),
      ),
    );
  }
}
// poniendo stateless y ate tabula esto
class _customButton extends StatelessWidget {
  var texto = "Botón personalizado";
  @override
  Widget build(BuildContext context) {
    return ClipRRect(
      borderRadius: .circular(20),
      child: Material(
        color: const Color.fromRGBO(255, 211, 194, 1),
        child: InkWell(
          onTap: () {
            texto = "Presionado";
          },
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text(texto),
          ),
        ),
      ),
    );
  }
}
