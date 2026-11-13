import mysql.connector
from conectarFormulario import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication, QMessageBox


class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.show()

        self.setWindowTitle("Conectar a la BBDD")

        try:
            self.con = mysql.connector.connect( # con es el nombre de la conexion, pude ser el quequeramos
                host="localhost",
                port=3306,
                user="root",
                password="1234",
                database="capitales"
            )
        except mysql.connector.Error as error:
            print(error)

        self.cargardatos()

        self.actual = 0
        self.tamano = len(self.resultado)

        self.lineEdit.setText(self.resultado[0][0])
        self.lineEdit_2.setText(self.resultado[0][1])
        self.lineEdit_3.setText(str(self.resultado[0][2]))


        self.pushButton.pressed.connect(lambda: self.situar(0))  # Primero
        self.pushButton_2.pressed.connect(self.anterior)
        self.pushButton_3.pressed.connect(self.siguiente) 
        self.pushButton_4.pressed.connect(lambda: self.situar(self.tamano - 1))  # Último


    def situar(self, pos):
        self.actual=pos
        self.lineEdit.setText(self.resultado[pos][0])
        self.lineEdit_2.setText(self.resultado[pos][1])
        self.lineEdit_3.setText(str(self.resultado[pos][2]))

    def siguiente(self):
        if(self.actual!=self.tamano - 1):
            self.actual+=1
            self.lineEdit.setText(self.resultado[self.actual][0])
            self.lineEdit_2.setText(self.resultado[self.actual][1])
            self.lineEdit_3.setText(str(self.resultado[self.actual][2]))
        else:
            dlg = QMessageBox(self)
            dlg.setWindowTitle("Limite alcanzado")
            dlg.setText("No hay más elementos")
            dlg.setStandardButtons(QMessageBox.StandardButton.Ok)
            dlg.exec()
            
    def anterior(self):
        if(self.actual!=0):
            self.actual-=1
            self.lineEdit.setText(self.resultado[self.actual][0])
            self.lineEdit_2.setText(self.resultado[self.actual][1])
            self.lineEdit_3.setText(str(self.resultado[self.actual][2]))
        else:
            dlg = QMessageBox(self)
            dlg.setWindowTitle("Limite alcanzado")
            dlg.setText("No hay más elementos")
            dlg.setStandardButtons(QMessageBox.StandardButton.Ok)
            dlg.exec()

    def cargardatos(self):
        # Creo el cursor
        cursor = self.con.cursor() 
        sql="SELECT * FROM capitales"
        # Ejecuto la consulta con el cursor
        cursor.execute(sql)


        # Recorro los resultados y los imprimo

        # Todos

        # Recojo los resultados
        self.resultado=cursor.fetchall()

        #for row in resultado:
        #    print(row)

        ## Provincias
        #for row in resultado:
        #    print(row[0])

        ## Los 10 primeros
        #for i in range (0,10):
        #    print(cursor.fetchone())

app = QApplication([])
ventana = MainWindow()
ventana.show()
app.exec()
