import 'package:flutter/material.dart';

class Pantalla5 extends StatelessWidget {
  const Pantalla5({super.key});

  @override
  Widget build(BuildContext context) {

    final menuOptions = ["p1","p2","p4"];

    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text('Pantalla 5', style: TextStyle(color: Colors.white),),
        backgroundColor: Colors.yellow,
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