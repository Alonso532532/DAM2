import 'package:flutter/material.dart';

class Pantalla3 extends StatelessWidget {
  const Pantalla3({super.key});

  @override
  Widget build(BuildContext context) {

    final menuOptions = ["p1","p2"];

    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text('Pantalla 3', style: TextStyle(color: Colors.white),),
        backgroundColor: Colors.blue,
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