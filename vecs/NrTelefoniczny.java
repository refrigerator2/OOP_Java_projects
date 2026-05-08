
class NrTelefoniczny implements Comparable<NrTelefoniczny> 
{
  private String nrKierunkowy;
  private String nrTelefonu;

  public NrTelefoniczny(String nrKierunkowy, String nrTelefonu) 
  {
    this.nrKierunkowy = nrKierunkowy;
    this.nrTelefonu = nrTelefonu;
  }

  @Override
  public int compareTo(NrTelefoniczny o) 
  {
    int res = this.nrKierunkowy.compareTo(o.nrKierunkowy);
    if (res == 0) 
    {
      return this.nrTelefonu.compareTo(o.nrTelefonu);
    }
    return res;
  }

  @Override
  public String toString() 
  {
    return "(" + nrKierunkowy + ") " + nrTelefonu;
  }
}
