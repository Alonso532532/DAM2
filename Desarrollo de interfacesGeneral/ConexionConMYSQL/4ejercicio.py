import mysql.connector
from formulario4 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication, QMessageBox


class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.show()

        self.setWindowTitle("Conectar BD")

        try:
            self.con = mysql.connector.connect( # con es el nombre de la conexion, pude ser el quequeramos
                host="localhost",
                port=3306,
                user="root",
                password="1234",
                database="piezas"
            )
        except mysql.connector.Error as error:
            print(error)

        self.index = 0

        self.cargarTipos()

        self.comboBox.currentIndexChanged.connect(self.cargarDatos)

        self.pushButton.pressed.connect(self.primero)
        self.pushButton_2.pressed.connect(self.restar)
        self.pushButton_3.pressed.connect(self.sumar)
        self.pushButton_4.pressed.connect(self.ultimo)

    def cargarTipos(self):
        cursor = self.con.cursor() 

        sql="select Tipo from tipo"
        
        cursor.execute(sql)

        self.resultado=cursor.fetchall()

        self.comboBox.addItems(tipo[0] for tipo in self.resultado)

        self.comboBox.setCurrentIndex(0)

        self.cargarDatos()

    def cargarDatos(self):
        cursor = self.con.cursor() 

        sql="select * from piezas where tipo = %s"
        
        cursor.execute(sql,(str(self.comboBox.currentIndex()+1),))

        self.resultado=cursor.fetchall()

        self.index = 0
        self.actualizarDatos()

    def actualizarDatos(self):
        self.lineEdit.setText(str(self.resultado[self.index][0]))
        self.lineEdit_2.setText(str(self.resultado[self.index][1]))
        self.lineEdit_3.setText(str(self.resultado[self.index][2]))
        self.lineEdit_4.setText(str(self.resultado[self.index][3]))

    def sumar(self):
        self.index+=1
        self.actualizarDatos()

    def restar(self):
        self.index-=1
        self.actualizarDatos()

    def primero(self):
        self.index=0
        self.actualizarDatos()

    def ultimo(self):
        self.index=len(self.resultado)-1
        self.actualizarDatos()
    

app = QApplication([])
ventana = MainWindow()
ventana.show()
app.exec()
