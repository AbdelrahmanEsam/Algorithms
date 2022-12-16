fun Int.isPrime() : Boolean
{
    if (this <= 1) return false
    for (i in 2..this/2)
    {
        if (this % i == 0) return false
    }

    return true
}
