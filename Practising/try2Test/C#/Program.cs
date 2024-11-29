using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicios
{
    public class Program
    {
        public static async Task Main(string[] args)
        {
            Task<int> tarea  = TareaCostosaAsync(); // Aquí deberíamos llamar a la versión asíncrona que utiliza una tarea
            Console.WriteLine("Este mensaje se debería mostrar mientras se realiza la tarea costosa, no cuando finaliza");
            int result = await tarea;
            Console.WriteLine(result); // Aquí mostraremos el valor devuelto por el nuevo método
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

        static async Task<int> TareaCostosaAsync()
        {
            int result = await Task.Run(() => TareaCostosa());
            return result;

        }
    }
}
