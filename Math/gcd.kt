fun gcd(a:Int ,b:Int) : Int
{
if (b == 0 ) return  a
    return  gcd(b,a%b) // make the bigger on right and check if the smaller equal 0
}


// to get the lcm = a*b /gcd
