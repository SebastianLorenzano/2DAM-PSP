namespace exercise11posta
{
    internal class Program
    {
        public static async Task Main(string[] args)
        {

            Paella p = new Paella();

            // Preparar caldo
            Cocinero cocinero = new Cocinero();
            Task<Caldo> tc = cocinero.PrepararCaldoAsync();

            // Calentar paella y sofreir ingredientes
            cocinero.CalentarPaella(p);
            cocinero.SofreirIngredientes(p, new List<string>() { "tomate", "pollo", "judías planas", "garrafó", "arroz" });

            Caldo c = await tc;
            // Echar el caldo
            cocinero.EcharCaldo(p, c);

            //Cocinar
            cocinero.Cocinar(p);

            Console.WriteLine("Paella lista: " + p);
            Console.ReadKey();

        }
    }
}
