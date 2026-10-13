import 'package:flutter/material.dart';
// Creo un widget para usarlo
class ContadorScreen extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text('Contador screen')
      )
    );
  }
}