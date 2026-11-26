import 'package:api_rest_1/models/post.dart';
import 'package:api_rest_1/services/posts_service.dart';
import 'package:flutter/material.dart';

class PostsScreen extends StatefulWidget {
   
  const PostsScreen({super.key});

  @override
  State<PostsScreen> createState() => _PostsScreenState();
}

class _PostsScreenState extends State<PostsScreen> {

  // Lista de posts, hay que incializarla a null mientras no tenga datos
  List<Post>? listaPosts;

  // Para saber si está cargando los datos
  bool isLoading = false;

  // Sobreescribo el initState para iniciar la carga de los posts nada más se inicie la app
  @override
  void initState() {
    super.initState();
    // TODO: implement initState
    obtenerPosts();
  }

  // Obtener los posts
  void obtenerPosts() async{
    listaPosts = await PostsService().obtenerPosts();

    // Marco la carga como completada si se reciven datos validos

    if (listaPosts!=null){
      setState(() {
        isLoading=true;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Posts"),
        backgroundColor: Colors.blue,
        centerTitle: true,
        titleTextStyle: TextStyle(
          fontSize: 30,
          fontWeight: .bold,
          color: Colors.white
        ),
      ),
      body: Visibility(
        visible: isLoading,
        replacement: Center(child:  CircularProgressIndicator.adaptive(),),
        child: ListView.builder(
          itemBuilder: (context, index) {
            return Padding(
              padding: const EdgeInsets.all(8.0),
              child: Row(
                // Separación entre los hijos del row
                spacing: 16,
                children: [
                  Container(
                    height: 50,
                    width: 50,
                    decoration:  BoxDecoration(
                      borderRadius: .circular(12),
                      // [100] es la transparencia
                      color: Colors.lightBlueAccent[100]
                    ),
                  ),
                  // Para que ocupe lo que tiene que ocupar
                  Expanded(
                    child: Column(
                      crossAxisAlignment: .start,
                      children: [
                        Text(listaPosts![index].title, maxLines: 2, overflow: .ellipsis, style: TextStyle(fontSize: 24, fontWeight: .bold,),),
                        Text(listaPosts![index].body ?? '', maxLines: 3, overflow: .ellipsis),
                      ],
                    ),
                  ),
                ],
              ),
            );
          },
          itemCount: listaPosts?.length,
          )
      ),
    );
  }

}