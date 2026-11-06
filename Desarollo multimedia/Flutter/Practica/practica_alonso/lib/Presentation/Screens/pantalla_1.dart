import 'package:flutter/material.dart';

class Pantalla1 extends StatelessWidget {
  const Pantalla1({super.key});

  @override
  Widget build(BuildContext context) {

    final menuOptions = ["p3","p4"];

    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text('Pantalla 1', style: TextStyle(color: Colors.white),),
        backgroundColor: Colors.red,
        elevation: 0,
      ),
      body: ListView.separated(
        itemBuilder: (context, i) => ListTile(
          leading: Icon(Icons.menu),
          title: Text("Pagina"+menuOptions[i].substring(1,2)),
          trailing: Icon(Icons.arrow_forward_ios),
          onTap: () {
            Navigator.pushNamed(context, menuOptions[i]);
          },
        ),
        separatorBuilder: (_, __) => Divider(), 
        itemCount: menuOptions.length
      ),
    );
  }
}