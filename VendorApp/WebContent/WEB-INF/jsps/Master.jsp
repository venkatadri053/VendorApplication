<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/common.css"></link>
<script type="text/javascript" src="../scripts/formValidations.js"></script>
</head>
<body>
<img src="../images/banner.jpg" width="500" height="150">
<div class="container">
  <div class="dropdown">
    <button class="dropbtn">Location</button>
    <div class="dropdown-content">
      <a href="locReg">Register</a>
      <a href="viewLocs">All Records</a>
    </div>
  </div> 
  <div class="dropdown">
    <button class="dropbtn">Vendor</button>
    <div class="dropdown-content">
      <a href="venReg">Register</a>
      <a href="viewAllVen">All Records</a>
    </div>
  </div> 
  <div class="dropdown">
    <button class="dropbtn">Customer</button>
    <div class="dropdown-content">
      <a href="custReg">Register</a>
      <a href="viewAllCust">All Records</a>
    </div>
  </div> 
  <div class="dropdown">
    <button class="dropbtn">Generic</button>
    <div class="dropdown-content">
      <a href="showDocs">Documents Page</a>
      <!-- <a href="viewAllVen">All Records</a> -->
    </div>
  </div>
  <div class="dropdown">
    <button class="dropbtn">Report</button>
    <div class="dropdown-content">
      <a href="locReport">Location</a>
      <a href="#">Vendor</a>
      <a href="userLogout">Logout</a>
    </div>
  </div> 
</div>
Welcome to User:${userName} 
</body></html>
