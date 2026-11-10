import 'dart:math';

import 'package:flutter/material.dart';

class AnimatedScreen extends StatefulWidget {
   
  const AnimatedScreen({super.key});

  @override
  State<AnimatedScreen> createState() => _AnimatedScreenState();
}

class _AnimatedScreenState extends State<AnimatedScreen> {

  double _width = 50;
  double _height =  50;
  Color _color = Colors.white;
  BorderRadiusGeometry _radio = BorderRadius.circular(10);

  void cambiarShape(){
    final random = Random();
    _width = random.nextInt(300).toDouble()+50;
    _height =  random.nextInt(600).toDouble()+50;
    _color = Color.fromRGBO(random.nextInt(255), random.nextInt(255), random.nextInt(255), 1);
    _radio = BorderRadius.circular(random.nextInt(100).toDouble());
    setState(() {});
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Animated Container"),
      ),
      body: Center(
         child: AnimatedContainer(
          duration: Duration(milliseconds: 1000),
          curve: Curves.bounceOut,
          width: _width,
          height: _height,
          decoration: BoxDecoration(
            color: _color,
            borderRadius: _radio
          ),
         )
      ),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.ac_unit),
        onPressed: () => cambiarShape(),
        
      ),
    );
  }
}