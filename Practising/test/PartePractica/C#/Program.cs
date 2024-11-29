using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicios
{
    class Program
    {
        static void Main(string[] args)
        {
            int res = TareaCostosa(); // Aquí deberíamos llamar a la versión asíncrona que utiliza una tarea
            Console.WriteLine("Este mensaje se debería mostrar mientras se realiza la tarea costosa, no cuando finaliza");
            Console.WriteLine(res); // Aquí mostraremos el valor devuelto por el nuevo método
            Console.ReadKey();
        }

        /* Método que simula una tarea costosa que devuelve un número. 
         * No podemos modificar su código ni firma
         * El nuevo método debería llamar a este método desde dentro de una tarea.*/
        static int TareaCostosa()
        {
            Task.Delay(2000).Wait();
            Random r = new Random();
            return r.Next();
        }

    }
}
