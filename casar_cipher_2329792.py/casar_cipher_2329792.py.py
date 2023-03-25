def welcome():
    """Prints a welcome message"""
    print("Welcome to the Caesar Cipher")
    print("This program encrypts and decrypts text with the Caesar Cipher.")

def enter_message():
    """Asks for encryption or decryption mode,and shift value and returns them"""
    while True:
        mode = input("Encrypt (e) or Decrypt (d): ").lower()
        if mode == "e" or mode == "d":
            break
    message = input("Enter your message: ").upper()
    shift = int(input("Enter shift value: "))
    if mode == "e":
        mode = "encrypt"
    else:
        mode = "decrypt"
    return (mode, message, shift)

def encrypt(message, shift):
    """Encrypts using shift value """
    encrypted_text = ""
    for char in message:
        if char.isalpha():
            shift_char = chr((ord(char) + shift - 65) % 26 + 65)
            encrypted_text += shift_char
    return encrypted_text

def decrypt(message, shift):
    """Decrypts using a shift value"""
    decrypted_text = ""
    for char in message:
        if char.isalpha():
            shift_char = chr((ord(char) - shift - 65) % 26 + 65)
            decrypted_text += shift_char
    return decrypted_text

def main():
    """Main functions of the program"""
    welcome()
    while True:
        mode, message, shift = enter_message()
        if mode == "encrypt":
            output = encrypt(message, shift)
        else:
            output = decrypt(message, shift)

        print("Output: ", output)

        repeat = input("Encrypt/Decrypt another message? (y/n) ").lower()
        if repeat != "y":
            break
    print("Thanks for using the program, goodbye!")

if __name__ == "__main__":
    main()
