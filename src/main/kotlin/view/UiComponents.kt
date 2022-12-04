package view

import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.*

interface UiComponents {
    val fetchQuoteButton: JButton
    val quoteTextArea: JTextArea
    val quoteCharacterField: JTextField

    fun openWindow()
}

private const val FETCH_QUOTE = "Quote!"
internal class UiComponentsImpl : UiComponents {

    override lateinit var fetchQuoteButton: JButton
    override lateinit var quoteCharacterField: JTextField
    override lateinit var quoteTextArea: JTextArea

    private lateinit var contentPanel : JPanel

    init {
        buildUI()
        setStyle()
    }

    override fun openWindow() {
        val frame = JFrame()
        frame.contentPane = contentPanel
        frame.minimumSize = Dimension(300, 300)
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        frame.pack()
        frame.isVisible = true
    }

    private fun buildUI() {
        addContentPanel()
        addFetchQuotePanel()
        addQuoteTextPanel()
        addQuoteCharacterPanel()
    }

    private fun addContentPanel() {
        contentPanel = JPanel()
        contentPanel.layout = BoxLayout(contentPanel, BoxLayout.PAGE_AXIS)
    }

    private fun addFetchQuotePanel() {
        val fetchQuotePanel = JPanel()
        fetchQuotePanel.layout = BorderLayout()
        fetchQuotePanel.maximumSize = Dimension(400, 50)
        fetchQuoteButton = JButton(FETCH_QUOTE)
        fetchQuotePanel.add(fetchQuoteButton)
        contentPanel.add(fetchQuotePanel)
    }

    private fun addQuoteTextPanel() {
        val quoteTextPanel = JPanel()
        quoteTextPanel.layout = BorderLayout()
        quoteTextPanel.maximumSize = Dimension(400, 300)
        quoteTextArea = JTextArea()
        quoteTextArea.lineWrap = true
        quoteTextArea.wrapStyleWord = true
        quoteTextArea.autoscrolls = true
        quoteTextPanel.add(quoteTextArea)
        contentPanel.add(quoteTextPanel)
    }

    private fun addQuoteCharacterPanel() {
        val quoteCharacterPanel = JPanel()
        quoteCharacterPanel.layout = BorderLayout()
        quoteCharacterPanel.maximumSize = Dimension(400, 50)
        quoteCharacterField = JTextField()
        quoteCharacterPanel.add(quoteCharacterField)
        contentPanel.add(quoteCharacterPanel)
    }

    private fun setStyle() {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
    }

}
