import '../assets/css/table.css'
 


 
function Table() {
    return (
<div class="row">
  <div class="column">
    <table>
      <tr>
        <th>Client_Id</th>
        <th>Client_Name</th>
        <th>Order</th>
      </tr>
      <tr>
        <td>1</td>
        <td>Jesiah</td>
        <td>Fridge</td>
      </tr>
      <tr>
        <td>2</td>
        <td>Jesmi</td>
        <td>Television</td>
      </tr>
      <tr>
        <td>3</td>
        <td>Nivetha</td>
        <td>Iron Box</td>
      </tr>
    </table>
  </div>
  <div class="column1">
    <table>
      <tr>
        <th>Pdt_Id</th>
        <th>Pdt_Name</th>
        <th>Price</th>
      </tr>
      <tr>
        <td>1</td>
        <td>Fridge</td>
        <td>30,000</td>
      </tr>
      <tr>
        <td>2</td>
        <td>Television</td>
        <td>15,000</td>
      </tr>
      <tr>
        <td>3</td>
        <td>Iron Box</td>
        <td>7,000</td>
      </tr>
    </table>
  </div>
</div>

    );
}
 
export default Table;