import 'package:flutter/material.dart';
import 'package:gestor_de_estados/pages/pagina1.dart';
import 'package:gestor_de_estados/pages/pagina2.dart';
import 'package:gestor_de_estados/pages/pagina3.dart';
import 'package:gestor_de_estados/providers/contador_provider.dart';
import 'package:provider/provider.dart';

class HomeScreen extends StatefulWidget {
   
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {

    List<Widget> _paginas = [Pagina1(), Pagina2(), Pagina3()];
    int _pagActual = 0;

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: Text("Gestor de estados"),
        actions: [
          Text(context.watch<ContadorProvider>().contador.toString())
        ],
        ),
      body: _paginas[_pagActual],
      bottomNavigationBar: BottomNavigationBar(
        selectedItemColor: Colors.white,
        backgroundColor: Colors.brown,
        onTap: (value) {
          setState(() {
          });
          _pagActual = value;
        },
        currentIndex: _pagActual,
        items: [
          BottomNavigationBarItem(icon: Icon(Icons.home), label: "Pagina 1"),
          BottomNavigationBarItem(icon: Icon(Icons.search), label: "Pagina 2"),
          BottomNavigationBarItem(icon: Icon(Icons.person), label: "Pagina 3")
        ]
      ),
    );
  }
}