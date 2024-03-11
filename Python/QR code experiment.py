import qrcode

def create_qr_code(data, filename='qrcode.png'):
    # Create QR code instance
    qr = qrcode.QRCode(
        version=1,
        error_correction=qrcode.constants.ERROR_CORRECT_L,
        box_size=10,
        border=4,
    )

    # Add data to the QR code
    qr.add_data(data)
    qr.make(fit=True)

    # Create an image from the QR code
    img = qr.make_image(fill_color="black", back_color="white")

    # Save the image
    img.save(filename)

if __name__ == "__main__":
    # Replace 'your_data_here' with your actual data
    data_to_encode = "https://rajputaryansh07.wixstudio.io/pythoncode"

    # Replace 'output_qr_code.png' with your desired output file name
    create_qr_code(data_to_encode, 'output_qr_code.png')

    print("QR code generated successfully.")
