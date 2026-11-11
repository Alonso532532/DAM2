import 'package:flutter/material.dart';

class Pantalla5 extends StatelessWidget {
  const Pantalla5({super.key});

  @override
  Widget build(BuildContext context) {
    final menuOptions = ["p1", "p2", "p4"];

    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: const Text('Pantalla 5', style: TextStyle(color: Colors.white)),
        backgroundColor: Colors.yellow,
        elevation: 0,
      ),
      body: ListView.separated(
        itemBuilder: (context, i) {
          // El último elemento es el botón de volver al inicio
          if (i == menuOptions.length) {
            return ListTile(
              leading: const Icon(Icons.home),
              title: const Text("Volver al inicio"),
              onTap: () {
                Navigator.popUntil(context, (route) => route.isFirst);
              },
            );
          }

          return ListTile(
            leading: const Icon(Icons.menu),
            title: Text("Pagina" + menuOptions[i].substring(1, 2)),
            trailing: const Icon(Icons.arrow_forward_ios),
            onTap: () {
              Navigator.pushNamed(context, menuOptions[i]);
            },
          );
        },
        separatorBuilder: (_, __) => const Divider(),
        itemCount: menuOptions.length + 1,
      ),
    );
  }
}