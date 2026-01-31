# Premium ATM Interface System

A comprehensive, professional-grade ATM simulation system built in Java with advanced features and security.

## Features

### Core Functionality
- ✅ **Account Management**: Secure bank account with PIN protection
- ✅ **Withdraw Money**: Validate withdrawals with balance and limit checks
- ✅ **Deposit Money**: Validate deposits with minimum/maximum limits
- ✅ **Check Balance**: Real-time balance inquiry
- ✅ **Transaction History**: Complete transaction logging with timestamps

### Security Features
- 🔒 **PIN Authentication**: Secure PIN verification system
- 🔒 **Account Locking**: Automatic account lock after 3 failed PIN attempts
- 🔒 **Input Validation**: Comprehensive validation for all user inputs
- 🔒 **Transaction Limits**: Enforced minimum and maximum transaction amounts

### Premium Features
- 💎 **Transaction History**: Detailed transaction records with timestamps
- 💎 **Professional UI**: Clean, user-friendly menu-driven interface
- 💎 **Error Handling**: Graceful error handling with informative messages
- 💎 **Multiple Accounts**: Support for multiple bank accounts
- 💎 **Balance Validation**: Prevents overdrafts and ensures account integrity

## System Architecture

### Class Structure

1. **BankAccount.java**
   - Manages account data (account number, PIN, balance)
   - Handles PIN verification and account locking
   - Maintains transaction history
   - Enforces balance constraints

2. **ATM.java**
   - Core ATM machine logic
   - Handles authentication
   - Processes withdrawals, deposits, and balance checks
   - Validates transaction limits
   - Returns structured transaction results

3. **Transaction.java**
   - Represents individual transaction records
   - Stores transaction type, amount, balance, and timestamp
   - Provides formatted transaction display

4. **ATMInterface.java**
   - Main user interface and menu system
   - Handles user input and validation
   - Manages application flow and session handling
   - Provides sample accounts for demonstration

## Usage

### Compilation
```bash
javac *.java
```

### Execution
```bash
java ATMInterface
```

### Demo Accounts
The system comes with three pre-configured demo accounts:

| Account Number | PIN | Initial Balance |
|---------------|-----|-----------------|
| 123456        | 1234| $5,000.00       |
| 789012        | 5678| $2,500.00       |
| 345678        | 9012| $10,000.00      |

## Transaction Limits

- **Withdrawal**: Minimum $10.00, Maximum $5,000.00
- **Deposit**: Minimum $5.00, Maximum $10,000.00

## Menu Options

1. **Check Balance** - View current account balance
2. **Withdraw Money** - Withdraw funds from account
3. **Deposit Money** - Deposit funds into account
4. **Transaction History** - View complete transaction log
5. **Logout** - End current session

## Security Features

- PIN authentication required for all operations
- Account automatically locks after 3 failed PIN attempts
- Input validation prevents invalid transactions
- Balance validation prevents overdrafts
- Transaction limits prevent excessive transactions

## Code Quality

- ✅ Comprehensive JavaDoc documentation
- ✅ Proper encapsulation and data hiding
- ✅ Clean separation of concerns
- ✅ Exception handling and error management
- ✅ Professional coding standards
- ✅ User-friendly error messages

## Technical Highlights

- Object-oriented design principles
- Secure PIN handling
- Transaction logging system
- Input validation and sanitization
- Professional user interface design
- Modular and extensible architecture

## Future Enhancements

Potential additions for extended functionality:
- Database integration for persistent storage
- Multiple account types (checking, savings)
- Transfer between accounts
- Bill payment functionality
- ATM card number support
- Receipt printing
- Multi-language support

---

**Developed with:** Java  
**Architecture:** Object-Oriented Design  
**Status:** Production Ready ✨

