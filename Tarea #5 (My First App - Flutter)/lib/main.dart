import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Mi primera aplicación',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String displayText = 'Gojo con vendas';
  String imageUrl = 'https://practicarte.com/wp-content/uploads/2021/04/Como-Dibujar-a-Satoru-Gojo-de-Jujutsu-Kaisen-Imagenes-Y-Consejos-23232.png';
  bool isClicked = false;

  void changeState() {
    setState(() {
      if (!isClicked) {
        displayText = 'Gojo sin vendas';
        imageUrl = 'https://static.wikia.nocookie.net/jujutsu-kaisen/images/5/5a/Satoru_Gojo_arrives_on_the_battlefield_%28Anime%29.png/revision/latest?cb=20210226205256';
      } else {
        displayText = 'Gojo con vendas';
        imageUrl = 'https://practicarte.com/wp-content/uploads/2021/04/Como-Dibujar-a-Satoru-Gojo-de-Jujutsu-Kaisen-Imagenes-Y-Consejos-23232.png';
      }
      isClicked = !isClicked;
    });
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Mi aplicación en Flutter'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Container(
              margin: EdgeInsets.all(10),
              padding: EdgeInsets.all(10),
              decoration: BoxDecoration(
                color: Colors.blue,
                borderRadius: BorderRadius.circular(10),
              ),
              child: Text(
                displayText,
                style: TextStyle(
                  color: Colors.white,
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ),
            SizedBox(height: 20),
            GestureDetector(
              onTap: changeState,
              child: Image.network(
                imageUrl,
                width: 200,
                height: 200,
              ),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: changeState,
              child: Text(
                'Presionar',
                style: TextStyle(fontSize: 20.0),
              ),
            ),
          ],
        ),
      ),
    );
  }
}