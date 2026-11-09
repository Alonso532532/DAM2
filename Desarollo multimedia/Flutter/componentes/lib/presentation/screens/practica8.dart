import 'package:flutter/material.dart';

class ExpansiblePractica extends StatelessWidget {
  const ExpansiblePractica({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Expansible"),
      ),
      body: Padding(
        padding: const EdgeInsetsDirectional.fromSTEB(30, 0, 30, 0),
        child: ExpansionTile(
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(16),
            side: const BorderSide(color: Colors.black87, width: 1),
          ),
          leading: Icon(Icons.shopping_basket),
          title: Text("Frutas"),
          initiallyExpanded: true,
          children: [
            ListTile(title: const Text("Manzana"), onTap: (){},),
            ListTile(title: Text("Pera"), onTap: (){},),
            ListTile(title: Text("Naranja"), onTap: (){},),
          ],
        ),
      ),
    );
  }
}